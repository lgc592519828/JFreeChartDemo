package cn.gcheng.demo;
/**
 * 柱状图
 */

import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarDemo {
	
	public static void main(String[] args) {
		//得到数据集
		CategoryDataset dataset = getDataset();
		//绘制图表
		JFreeChart chart = getJFreeChart("客户分析统计报表(客户等级)", "客户等级", "数量", dataset, 
				  		 PlotOrientation.VERTICAL, true, true, true);
		doEnCoding(chart);
		
		//ChartFrame 继承 java.swing包  ：图形化
		ChartFrame frame = new ChartFrame("xxx", chart);
		//可见属性
		frame.setVisible(true);
		frame.pack();
	}
	/**
	 * 生成图表
	 * @param title			主标题
	 * @param categoryAxisLabel	轴标题
	 * @param valueAxisLabel	Y轴标题
	 * @param dataset		图表需要的数据 	CategoryDataset接口
	 * @param orientation	 	图标的方法(水平或垂直)(PlotOrientation类中常量)
	 * @param legend		是否显示图例
	 * @param tooltips		是否显示工具提示
	 * @param urls			是否产生RUL连接
	 * @return
	 */
	private static JFreeChart getJFreeChart(String title, String categoryAxisLabel, String valueAxisLabel, 
						CategoryDataset dataset, PlotOrientation orientation, 
						Boolean legend, Boolean tooltips, Boolean urls){
		JFreeChart chart = ChartFactory.createBarChart3D(title, categoryAxisLabel, valueAxisLabel, 
								 dataset, orientation, legend, tooltips, urls);
		return chart;
	}
	
	/**
	 * 返回图标需要的数据
	 * @return
	 */
	private static CategoryDataset getDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(1, "客户等级", "机会客户");
		dataset.setValue(2, "客户等级", "潜在客户");
		dataset.setValue(3, "客户等级", "重要客户");
		dataset.setValue(2, "客户等级", "签约客户");
		
		return dataset;
	}
	
	/**
	 * 处理字符集问题 以及 工具类的使用
	 * @param chart 图标对象
	 */
	private static void doEnCoding(JFreeChart chart){
		//获取图标对象：
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		//获取X轴
		CategoryAxis3D domainAxis = (CategoryAxis3D) plot.getDomainAxis();
		//获取Y轴
		NumberAxis3D numberAxis3D = (NumberAxis3D) plot.getRangeAxis();
		
		//处理主标题乱码: 需要new一个Font对象，设置字体、样式、大小
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		//处理子标题乱码：
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		//处理X轴乱码：
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); //x轴上
		domainAxis.setLabelFont(new Font("宋体", Font.BOLD, 15)); 	 //x轴外
		//处理Y轴乱码：
		numberAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		numberAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		
		//处理Y轴刻度
			//自动刻度
		numberAxis3D.setAutoTickUnitSelection(false); 
			//设置刻度
		NumberTickUnit  size = new NumberTickUnit(1);
		numberAxis3D.setTickUnit(size);
		
		//处理柱状图宽度
		BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
		renderer.setMaximumBarWidth(0.08);
		//处理柱状图上的标识数字以及设置大小字体
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 10));
	}
	
	
	
}
