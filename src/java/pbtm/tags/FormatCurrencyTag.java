/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbtm.tags;

import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Dylan
 */
public class FormatCurrencyTag extends TagSupport {
  private Double currencyAmount;
  
  public void setCurrencyAmount(Double currencyAmount) {
    this.currencyAmount = currencyAmount;
  }
  
  public Double getCurrencyAmount() {
    return this.currencyAmount;
  }
  
  @Override
  public int doStartTag() throws JspException {
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    String currency = currencyFormat.format(currencyAmount);

    try {
      JspWriter out = pageContext.getOut();
      out.print(currency);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
    return SKIP_BODY;
  }
}
