package mianxiangduixiang1;

import java.util.Scanner;

public class DingCan {

	public static void main(String[] args) {
		//定义数据主题，一组订单信息
		int k=4;//订餐信息条数
		String[] names=new String[k];//订餐人
		String[] dishmegs=new String[k];//所订餐品信息
		int []times=new int[k];//送餐时间
		String[] addresses=new String[k];//送餐地址
		int []states=new int[k];//订餐状态，0表示已预定状态，1表示已完成状态
		double []sumprices=new double[k];//总金额
		
		//初始化2条订单信息
		names[0]="张晴";
		dishmegs[0]="红烧带鱼 2份";
		times[0]=12;
		addresses[0]="天成路209号";
		states[0]=1;
		sumprices[0]=24;
		
		names[1]="张晴";
		dishmegs[1]="鱼香肉丝 2份";
		times[1]=12;
		addresses[1]="天成路209号";
		states[1]=0;
		sumprices[1]=76;
		
		//数据主题，一组餐品信息
		String[] dishnames={"红烧带鱼","鱼香肉丝","时令蔬菜"};//餐品名
		double[] prices={38.0,18.0,10.0};//餐品单价
		int[] praisenums=new int[3];//使用数组元素的默认值，点赞数
		
		Scanner input=new Scanner(System.in);
		//主体部分：循环(do-while);
		int num=-1;//记录用户输入的数字
		do{
			//循环操作:
			//显示主菜单;
			System.out.println("**********************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("**********************************");

			//提示用户输入功能编号,并执行相应功能;
			System.out.print("请选择");
			int choose=input.nextInt();
			
			boolean isAdd=false;//用来记录插入是否成功
			switch(choose){
			case 1:
				//我要订餐
				System.out.println("********我要订餐*******");
				//1.查找要插入的位置
				for(int i=0;i<names.length;i++){
					//如果找到为空的位置，记录下来
					if(names[i]==null){
						isAdd=true;//记录找到一个为空的位置
						//执行插入操作
						//a.显示所有可供选择的餐品信息
						System.out.println("序号\t餐品名\t单价\t点赞数");
						for(int j=0;j<dishnames.length;j++){
							String price=prices[j]+"元";
							String praise=praisenums[j]+"赞";
							System.out.println((j+1)+"\t"+dishnames[j]+"\t"+price+"\t"+praise+"\t");
						}
						
						//输入所选餐品编号以及份数
						System.out.print("请选择所订餐品的序号：");
						int choosedish=input.nextInt();
						System.out.print("请选择所订餐品的份数：");
						int number=input.nextInt();
						String dishmeg=dishnames[choosedish-1]+" "+number+"份";
						
						//b.输入订餐人的姓名
						System.out.print("请输入订餐人的姓名：");
						String name=input.next();
						
						//c.输入送餐时间
						System.out.print("请输入送餐时间(10-20整点送餐)");
						int time=input.nextInt();
						//如果输入错误，重复输入
						while(time<10||time>20){
							System.out.print("您的输入有误，请输入10-20的整数:");
							time=input.nextInt();
						}
						
						//d.输入送餐地址
						System.out.print("请输入送餐地址:");
						String address=input.next();
						
						//e计算餐费
						double sumprice=prices[choosedish-1]*number;
						//当餐费达到50元时，免6元送餐费
						double delicharge=sumprice>=50?0.0:6.0;
						
						//显示订单信息
						System.out.println("订餐成功！");
						System.out.println("您订的是:"+dishmeg);
						System.out.println("订餐人:"+name);
						System.out.println("送餐时间:"+time+"点");
						System.out.println("送餐地址:"+address);
						System.out.println("餐费:"+sumprice+",送餐费:"+delicharge+"元");
						System.out.println("总金额:"+(sumprice+delicharge)+"元");
						
						//保存数据
						names[i]=name;
						dishmegs[i]=dishmeg;
						times[i]=time;
						addresses[i]=address;
						sumprices[i]=sumprice+delicharge;
						
						break;
					}
				}
				//如果没有找到为空的位置，则提示餐袋已满
				if(!isAdd){
					System.out.println("对不起，您的餐袋已满！");
				}
				break;
			case 2:
				//查看餐袋
				System.out.println("*********查看餐袋*********");
				System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t送餐地址\t总金额\t订单状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"点";
						String sumprice=sumprices[i]+"元";
						String state=states[i]==0?"已预定":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t\t"+dishmegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumprice+"\t"+state);
					}
				}
				break;
			case 3:
				//签收订单
				System.out.println("********签收订单********");
				System.out.println("请输入要签收的订单序号");
				int signorderid=input.nextInt();
				boolean isFind=false;//用来记录是否找到该订单
				//查找这条订单
				for(int i=0;i<names.length;i++){
					//找到这条订单，已完成签收
					if(names[i]!=null&&states[i]==1&&signorderid==i+1){
						System.out.println("您选择的订单已完成签收,不能再次签收！");
						isFind=true;
						break;
					}else if(names[i]!=null&&states[i]==0&&signorderid==i+1){
						//找到这条订单，已预定状态
						states[i]=1;//修改状态
						System.out.println("订单签收成功");
						isFind=true;
						break;
					}
				}
				//如果没有找到该订单，提示未找到该订单
				if(!isFind){
					System.out.println("此订单不存在！");
				}
				
				break;
			case 4:
				//删除订单
				//1.输入要删除的订单序号
				System.out.println("********删除订单********");
				System.out.print("请输入要删除的订单序号");
				int delld=input.nextInt();
				int delindex=-1;//用来记录需要删除订单的下标
				boolean isdelfind=false;//记录是否找到此条订单
				//2.循环查找这条订单
				for(int i=0;i<names.length;i++){
				//找到这条订单，已完成状态，执行删除操作(先记录要删除的订单序号)
					//序号从1开始的，即：下标=序号-1
					if(names[i]!=null&&states[i]==1&&delld==i+1){
						delindex=i;
						isdelfind=true;
						break;
					
					//找到这条订单，已预定状态，提示无法删除
					}else if(names[i]!=null&&states[i]==0&&delld==i+1){
						System.out.println("您选择的订单未签收不能删除");
						isdelfind=true;
						break;
					}
				}
				//如果没有找到该订单，提示未找到该订单
				if(!isdelfind){
					System.out.println("对不起，此条订单不存在!");
				}
				//执行删除操作,循环移位
				if(delindex!=-1){
					//从要删除后面一个元素开始到数组最后一个元素依次向前移动一位,最后一位清空
					for(int i=delindex+1;i<names.length;i++){
						names[i-1]=names[i];
						dishmegs[i-1]=dishmegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
					//最后一位清空
					names[names.length-1]=null;
					dishmegs[dishmegs.length-1]=null;
					times[times.length-1]=0;
					addresses[addresses.length-1]=null;
					states[states.length-1]=0;
					
					System.out.println("订单删除成功！");
				}
				break;
			case 5:
				//我要点赞
				System.out.println("********我要点赞********");
				//1。显示供点赞的餐品列表
				System.out.println("序号\t餐品名\t单价\t点赞数");
				for(int j=0;j<dishnames.length;j++){
					String price=prices[j]+"元";
					String praise=praisenums[j]+"赞";
					System.out.println((j+1)+"\t"+dishnames[j]+"\t"+price+"\t"+praise+"\t");
				}
				//2.输入要点赞的餐品信息
				System.out.println("请输入要点赞的餐品序号：");
				int dishid=input.nextInt();
				//3.该序号的点赞数加一
				praisenums[dishid-1]++;
				//显示
				System.out.println("点赞成功！");
				System.out.println(dishnames[dishid-1]+" "+praisenums[dishid-1]+"赞");
				
				break;
			case 6:
				//退出系统
				break;
			default:
				break;
				
			}
			//当用户输入的功能编号为1-5之外的数字,退出循环,否则将会提示输入0返回
			if(choose<1||choose>5){
				break;
			}else{
			//提示用户输入0返回;
			System.out.print("输入0返回");
			num=input.nextInt();
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临");
		
		
		
		
	}

}
