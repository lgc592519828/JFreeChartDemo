# JFreeChartDemo
**利用JFreeChart工具绘制图表Demo**

1. JFreeChart图表
   主要元素包含：
      * 主标题
      * 子标题 (图例)
      * 图表区域对象    xxxPlot
		

-----------------------------------------------------------

2. 柱状图：
  图表区域对象    xxxPlot
	* x轴    xxxAXis
	* y轴    xxxAXis
	* 绘图区域对象    xxxRender
	
-----------------------------------------------------------	
柱状图图表含有xy轴,而折线图、饼图没有,这点需要注意  
   * 如果想在图表区域显示一些属性时,要获取图表对象：  
      * `chart.getPlot();`  
   * 然后根据获取的图表对象操作,这里可以将图表对象强制转换成任何属性的图表对象(线、柱状图、饼图等),例如：  
      * //获取饼图图表对象：  
      * `PiePlot3D plot3d = (PiePlot3D) chart.getPlot();`  
      * //获取图表对象：  
      * `CategoryPlot plot = (CategoryPlot) chart.getPlot();`  


---
**MAVEN依赖**  
```
<dependency>
   <groupId>jfree</groupId>  
   <artifactId>jfreechart</artifactId>  
   <version>1.0.13</version>  
</dependency>
```
---
**效果图**  
![](https://github.com/lgc592519828/JFreeChartDemo/blob/master/src/gcheng/images/柱状图.png)  
---
![](https://github.com/lgc592519828/JFreeChartDemo/blob/master/src/gcheng/images/线状图.png)  
---
![](https://github.com/lgc592519828/JFreeChartDemo/blob/master/src/gcheng/images/饼图.png)  


