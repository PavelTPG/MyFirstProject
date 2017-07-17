package SourceUser;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.sql.*;

/**
 * DBServlet
 *
 * Этот сервлет демонстрирует как использовать JDBC стек и получать доступ к
 * базам данных при помощи сервлетов. Для того, чтобы выполнить этот сервлет,
 * переменные CLASSPATH, LD_LIBRARY_PATH, ODBCINI должны быть соответствующим
 * образом установлены.
 */
public class PlaneServlet extends HttpServlet {

    /**
     * init method
     */
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
    }

    /**
     * service method
     */
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String id_plane;
        String date_start,
                date_end, city_begin, city_end;
        Connection connection = null;
        PrintStream out;
        /* ServletOutputStream out = res.getOutputStream();*/
// Загрузка параметров. Именно эти параметры должны будут вводиться
// в специально прорисованном окне браузера, с которым будет
// взаимодействовать наш сервлет

        id_plane = req.getParameter("id_plane");
        date_start = req.getParameter("date_start");
        date_end = req.getParameter("date_end");
        city_begin = req.getParameter("city_begin");
        city_end = req.getParameter("city_end");

        res.setContentType("text/html");
        out = new PrintStream(res.getOutputStream());
        printPageHeader(out);
// в том случае, если параметры отсутствуют
        if (id_plane == null || date_start == null || date_end == null
                || city_begin == null || city_end == null) {
            printPageFooter(out);
            return;
        }

        String drive = "com.mysql.jdbc.Drive";
        String url = "jdbc:mysql://localhost:3306/airlines";
        String user = "root";
        String password = "";

        out.println("<hr><h3>Previous Query</h3>");
        out.println("<pre>");

        out.println(" id_plane : " + id_plane);
        out.println(" date_start : " + date_start);
        out.println(" date_end : " + date_end);
        out.println(" city_begin : " + city_begin);
        out.println(" city_end : " + city_end);

        out.println("</pre>");
        try {
            Class.forName(drive);

// Получить соединение с базой данных
            connection = DriverManager.getConnection(url, user, password);
            out.println("<hr>");
            out.println("<h3>ODBC Driver and Database Messages</h3>");
            checkForWarning(connection.getWarnings(), out);
            DatabaseMetaData dma = connection.getMetaData();
            out.println("Connected to " + dma.getURL() + "<br>");
            out.println("Driver " + dma.getDriverName() + "<br>");
            out.println("Version " + dma.getDriverVersion() + "<br>");

            // Создать и выполнить запрос. Конкретный оператор SQL
            // вводится удаленным пользователем в окне его браузера
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(url);

            // Печать результатов. 
            //Они переназначаются на стандартный вывод
            // и поступают в браузер клиента
            dispResultSet(rs, out);
            rs.close();
            statement.close();
            connection.close();
            out.println("<hr>");
        } catch (SQLException ex) {
            out.println("<hr>*** SQLException caught ***");
            while (ex != null) {
                out.println("SQLState: " + ex.getSQLState() + "<br>");
                out.println("Message: " + ex.getMessage() + "<br>");
                out.println("Vendor: " + ex.getErrorCode() + "<br>");
                ex = ex.getNextException();
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        printPageFooter(out);
    }

    /**
     * возврат запрошенной информации
     */
    public String getServletInfo() {
        return " ";
    }


    /*
 * проверка и печать информации сервера
     */
    private void checkForWarning(SQLWarning warn, PrintStream out)
            throws SQLException {
        boolean rc = false;

        if (warn != null) {
            out.println("<hr>*** Warning ***");
            rc = true;
            while (warn != null) {
                out.println("SQLState: " + warn.getSQLState() + "<br>");
                out.println("Message: " + warn.getMessage() + "<br>");
                out.println("Vendor: " + warn.getErrorCode() + "<br>");
                warn = warn.getNextWarning();
            }
        }
    }

    /*
 * Показ результатов запроса в табличном html формате
     */
    private void dispResultSet(ResultSet rs, PrintStream out)
            throws SQLException, IOException {
        int i;

        // метаданные используются для получения информации о схеме
        ResultSetMetaData rsmd = rs.getMetaData();
        int numCols = rsmd.getColumnCount();
        out.println("<hr>");
        out.println("<h3>Database Columns and Data</h3>");
        out.println("<table border=3>");
        out.println("<tr>");
        for (i = 1; i <= numCols; i++) {
            out.println("<th>" + rsmd.getColumnLabel(i) + "</th>");
        }
        out.println("</tr>");

        // для всех данных
        while (rs.next()) {
            out.println("<tr>");

            // for one row
            for (i = 1; i <= numCols; i++) {
                dispElement(rs, rsmd.getColumnType(i), out, i);
            }
            out.println("</tr>");
        }
        out.println("</table>");
    }

    // печать одного элемента
    private void dispElement(ResultSet rs, int dataType,
            PrintStream out, int col)
            throws SQLException, IOException {
        String cp1 = new String("Cp1251");
        // в зависимости от типа
        //данных, определяем различные типы обработки
        switch (dataType) {
            case Types.DATE:
                java.sql.Date date = rs.getDate(col);
                out.println("<th>" + date.toString() + "</th>");
                break;
            case Types.TIME:
                java.sql.Time time = rs.getTime(col);
                out.println("<th>" + time.toString() + "</th>");
                break;
            case Types.TIMESTAMP:
                java.sql.Timestamp timestamp = rs.getTimestamp(col);
                out.println("<th>"
                        + timestamp.toString() + "</th>");
                break;
            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
                String str = rs.getString(col);
// Возможно, что здесь вам 
//понадобятся кириллические преобразования
                out.println("<th>" + str + "</th>");
                break;
            case Types.NUMERIC:
            case Types.DECIMAL:
                java.math.BigDecimal numeric = rs.getBigDecimal(col, 10);
                out.println("<th>" + numeric.toString() + "</th>");
                break;
            case Types.BIT:
                boolean bit = rs.getBoolean(col);
                out.println("<th>" + new Boolean(bit) + "</th>");
                break;
            case Types.TINYINT:
                byte tinyint = rs.getByte(col);
                out.println("<th>" + new Integer(tinyint) + "</th>");
                break;
            case Types.SMALLINT:
                short smallint = rs.getShort(col);
                out.println("<th>" + new Integer(smallint) + "</th>");
                break;
            case Types.INTEGER:
                int integer = rs.getInt(col);
                out.println("<th>" + new Integer(integer) + "</th>");
                break;
            case Types.BIGINT:
                long bigint = rs.getLong(col);
                out.println("<th>" + new Long(bigint) + "</th>");
                break;
            case Types.REAL:
                float real = rs.getFloat(col);
                out.println("<th>" + new Float(real) + "</th>");
                break;
            case Types.FLOAT:
            case Types.DOUBLE:
                double longreal = rs.getDouble(col);
                out.println("<th>" + new Double(longreal) + "</th>");
                break;
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
                byte[] binary = rs.getBytes(col);
                out.println("<th>" + new String(binary, 0) + "</th>");
                break;
        }
    }

    private void printPageHeader(PrintStream out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<tltle>Plane fly</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><font size=5>"
                + "<b>Jeeves Database Servlet</b>"
                + "</font></center>");
        out.println("<hr>");
        out.println("<form action=\"/AirLinesDAL/AbstractInterfaces/IPlaneDAO\" method=\"get\">");
        out.println("<pre>");
        out.println("ODBC DSN : <input type=textarea name=plane>");
        out.println(" Plane ID : <input type=textarea name=id_plane>");
        out.println("</pre>");
        out.println("<input type=submit>");
        out.println("</form>");
    }

    private void printPageFooter(PrintStream out) {
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
}
