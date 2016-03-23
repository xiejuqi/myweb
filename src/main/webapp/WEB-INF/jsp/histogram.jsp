<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath();%>
<%-- <script type="text/javascript" charset="utf-8" src="<%=path%>/js/jquery-1.9.1.min.js"></script> --%>
<script src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script> 
<script type="text/javascript">  
$(function () {
	
	function disPlay(data){
		var a = eval(data);
		console.info(a);
		console.info(data);
		var opt = {
		        chart: {
		            type: 'bar'
		        },
		        title: {
		            text: '万荣中学339班成绩表'
		        },
		        subtitle: {
		            text: '截止日期为2016-03-02 16：51'
		        },
		        xAxis: {
		            categories: ['第一学期', '第二学期', '第三学期', '第四学期', '第五学期'],
		            title: {
		                text: null
		            }
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'Population (millions)',
		                align: 'high'
		            },
		            labels: {
		                overflow: 'justify'
		            }
		        },
		        tooltip: {
		            valueSuffix: ' 分'
		        },
		        plotOptions: {
		            bar: {
		                dataLabels: {
		                    enabled: true
		                }
		            }
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'top',
		            x: -40,
		            y: 100,
		            floating: true,
		            borderWidth: 1,
		            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
		            shadow: true
		        },
		        credits: {
		            enabled: false
		        },
		        series: a
		    };
		    
		    $('#container').highcharts(opt);	
	}
	
	$.ajax({    
        type:'post',        
        url:'/myweb/getJsonString.html',    
        cache:false,    
        dataType:'json',    
        success:function(data){   
        	disPlay(data);
        }    
    }); 
	
		
	
});
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>Insert title here</title>
</head>
<body>
	<div id="container" style="min-width:400px;height:400px"></div>
</body>
</html>
