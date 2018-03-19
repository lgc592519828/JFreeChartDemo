package cn.gcheng.demo;
/**
 * 饼图
 */

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


public class PieDemo {
	
	public static void main(String[] args) throws IOException {
		//得到饼图数据集
		PieDataset dataset = getDataset();
		//绘制图表
		JFreeChart chart = getJFreeChart("客户分析统计报表(客户等级)", dataset, true, true, true);
		
		//使用工具类,处理字符编码
		doEnCoding(chart);
		
		//生成图片格式,前端调用
		File file = new File("C:/work/Cheng/pie.jpeg");
		ChartUtilities.saveChartAsJPEG(file, chart, 600, 400);
		
	}
	/**
	 * 生成图表
	 * @param title		主标题
	 * @param dataset	图表需要的数据 	
	 * @param legend	是否显示图例
	 * @param tooltips	是否显示工具提示
	 * @param urls		是否产生RUL连接
	 * @return
	 */
	private static JFreeChart getJFreeChart(String title, PieDataset dataset, 
			                        Boolean legend, Boolean tooltips, Boolean urls){
		JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, legend, tooltips, urls);
		return chart;
	}
	
	/**
	 * 返回图标需要的数据,注意格式,与柱状图、折线图不同
	 * @return
	 */
	private static PieDataset getDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("机会客户", 1);
		dataset.setValue("潜在客户", 2);
		dataset.setValue("重要客户", 3);
		dataset.setValue("签约客户", 2);
		
		return dataset;
	}
	
	/**
	 * 处理乱码问题 以及 工具类的使用
	 * @param chart 图标对象
	 */
	private static void doEnCoding(JFreeChart chart){
		//获取图标对象：
		PiePlot3D plot3d = (PiePlot3D) chart.getPlot();
		
		//处理主标题乱码: 需要new一个Font对象，设置字体、样式、大小
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		//处理子标题乱码：
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		
		//处理饼图标题乱码(饼图上的标签)
		plot3d.setLabelFont(new Font("宋体", Font.BOLD, 12));
		
		//处理饼图显示信息(StandardPieSectionLabelGenerator 生成器)
		/**
		 * String labelFormat = "{0}:{1}({2})";
		 * 例：
		 *  dataset.setValue("机会客户", 1);
			dataset.setValue("潜在客户", 2);
			dataset.setValue("重要客户", 3);
			dataset.setValue("签约客户", 2);
			{0}:显示前面的key
			{1}：显示后面的value
			{2}：显示占比  n%
		 * 
		 * :() 自定义格式
		 */
		String labelFormat = "{0}:{1}({2})";
		plot3d.setLabelGenerator(new StandardPieSectionLabelGenerator(labelFormat));
		
	}
	
}
