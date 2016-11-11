<!--©2016 Casey Hayes & Tanner McIntyre. All Rights Reserved.-->

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="elon" uri="/WEB-INF/tlds/pbtm.tld" %>
<%@ include file="/includes/header.html" %>

<h1>Future Value Calculator</h1>
  <p class="line"><span class="left">Investment Amount:</span>
      <span class="right"><elon:currencyFormat currencyAmount="${user.amount}" /></span></p>
  <p class="line"><span class="left">Yearly Interest Rate:</span>
      <span class="right">${user.rate}</span></p>
  <p class="line"><span class="left">Number of Years:</span>
      <span class="right">${user.years}</span></p>
  <p class="line"><span class="left">Future Value:</span>
    <span class="right"><elon:currencyFormat currencyAmount="${user.futureValue}" /></span></p>
  
  <p class="line"><a class="left" href="index.jsp">Return to Calculator</a></p>
  

<%@ include file="/includes/footer.jsp" %>