package br.com.springbank.util;


import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diogo
 */
public class Auxiliar {

    public static Date stringToDate(String data) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(data);
    }

    public static String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static String dateToStringFormatada(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
    
     public static Date stringToDateFormatada(String data) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(data);
    }
    

    /**
     *
     * @param date
     * @return
     */
    public static String dateToStringSql(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }

    public static Date stringToDateSql(String data) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.parse(data);
    }

    public static void redirecionar(HttpServletRequest request, HttpServletResponse response, String mensagem, String url) throws ServletException, IOException {
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("url", url);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    public static void redirecionarLogout(HttpServletRequest request, HttpServletResponse response, String mensagem) throws ServletException, IOException {
        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public static void setarStatus(HttpServletRequest request, HttpServletResponse response, String nomeStatus, String checked) {
        request.setAttribute(nomeStatus, checked);
    }

    public static BigDecimal stringToBigDecimal(String valorString) {
        BigDecimal valor = new BigDecimal(valorString);
        return valor;
    }

}
