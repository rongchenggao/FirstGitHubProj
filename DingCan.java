package mianxiangduixiang1;

import java.util.Scanner;

public class DingCan {

	public static void main(String[] args) {
		//�����������⣬һ�鶩����Ϣ
		int k=4;//������Ϣ����
		String[] names=new String[k];//������
		String[] dishmegs=new String[k];//������Ʒ��Ϣ
		int []times=new int[k];//�Ͳ�ʱ��
		String[] addresses=new String[k];//�Ͳ͵�ַ
		int []states=new int[k];//����״̬��0��ʾ��Ԥ��״̬��1��ʾ�����״̬
		double []sumprices=new double[k];//�ܽ��
		
		//��ʼ��2��������Ϣ
		names[0]="����";
		dishmegs[0]="���մ��� 2��";
		times[0]=12;
		addresses[0]="���·209��";
		states[0]=1;
		sumprices[0]=24;
		
		names[1]="����";
		dishmegs[1]="������˿ 2��";
		times[1]=12;
		addresses[1]="���·209��";
		states[1]=0;
		sumprices[1]=76;
		
		//�������⣬һ���Ʒ��Ϣ
		String[] dishnames={"���մ���","������˿","ʱ���߲�"};//��Ʒ��
		double[] prices={38.0,18.0,10.0};//��Ʒ����
		int[] praisenums=new int[3];//ʹ������Ԫ�ص�Ĭ��ֵ��������
		
		Scanner input=new Scanner(System.in);
		//���岿�֣�ѭ��(do-while);
		int num=-1;//��¼�û����������
		do{
			//ѭ������:
			//��ʾ���˵�;
			System.out.println("**********************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("**********************************");

			//��ʾ�û����빦�ܱ��,��ִ����Ӧ����;
			System.out.print("��ѡ��");
			int choose=input.nextInt();
			
			boolean isAdd=false;//������¼�����Ƿ�ɹ�
			switch(choose){
			case 1:
				//��Ҫ����
				System.out.println("********��Ҫ����*******");
				//1.����Ҫ�����λ��
				for(int i=0;i<names.length;i++){
					//����ҵ�Ϊ�յ�λ�ã���¼����
					if(names[i]==null){
						isAdd=true;//��¼�ҵ�һ��Ϊ�յ�λ��
						//ִ�в������
						//a.��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������");
						for(int j=0;j<dishnames.length;j++){
							String price=prices[j]+"Ԫ";
							String praise=praisenums[j]+"��";
							System.out.println((j+1)+"\t"+dishnames[j]+"\t"+price+"\t"+praise+"\t");
						}
						
						//������ѡ��Ʒ����Լ�����
						System.out.print("��ѡ��������Ʒ����ţ�");
						int choosedish=input.nextInt();
						System.out.print("��ѡ��������Ʒ�ķ�����");
						int number=input.nextInt();
						String dishmeg=dishnames[choosedish-1]+" "+number+"��";
						
						//b.���붩���˵�����
						System.out.print("�����붩���˵�������");
						String name=input.next();
						
						//c.�����Ͳ�ʱ��
						System.out.print("�������Ͳ�ʱ��(10-20�����Ͳ�)");
						int time=input.nextInt();
						//�����������ظ�����
						while(time<10||time>20){
							System.out.print("������������������10-20������:");
							time=input.nextInt();
						}
						
						//d.�����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ:");
						String address=input.next();
						
						//e����ͷ�
						double sumprice=prices[choosedish-1]*number;
						//���ͷѴﵽ50Ԫʱ����6Ԫ�Ͳͷ�
						double delicharge=sumprice>=50?0.0:6.0;
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("��������:"+dishmeg);
						System.out.println("������:"+name);
						System.out.println("�Ͳ�ʱ��:"+time+"��");
						System.out.println("�Ͳ͵�ַ:"+address);
						System.out.println("�ͷ�:"+sumprice+",�Ͳͷ�:"+delicharge+"Ԫ");
						System.out.println("�ܽ��:"+(sumprice+delicharge)+"Ԫ");
						
						//��������
						names[i]=name;
						dishmegs[i]=dishmeg;
						times[i]=time;
						addresses[i]=address;
						sumprices[i]=sumprice+delicharge;
						
						break;
					}
				}
				//���û���ҵ�Ϊ�յ�λ�ã�����ʾ�ʹ�����
				if(!isAdd){
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
			case 2:
				//�鿴�ʹ�
				System.out.println("*********�鿴�ʹ�*********");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"��";
						String sumprice=sumprices[i]+"Ԫ";
						String state=states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t\t"+dishmegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumprice+"\t"+state);
					}
				}
				break;
			case 3:
				//ǩ�ն���
				System.out.println("********ǩ�ն���********");
				System.out.println("������Ҫǩ�յĶ������");
				int signorderid=input.nextInt();
				boolean isFind=false;//������¼�Ƿ��ҵ��ö���
				//������������
				for(int i=0;i<names.length;i++){
					//�ҵ����������������ǩ��
					if(names[i]!=null&&states[i]==1&&signorderid==i+1){
						System.out.println("��ѡ��Ķ��������ǩ��,�����ٴ�ǩ�գ�");
						isFind=true;
						break;
					}else if(names[i]!=null&&states[i]==0&&signorderid==i+1){
						//�ҵ�������������Ԥ��״̬
						states[i]=1;//�޸�״̬
						System.out.println("����ǩ�ճɹ�");
						isFind=true;
						break;
					}
				}
				//���û���ҵ��ö�������ʾδ�ҵ��ö���
				if(!isFind){
					System.out.println("�˶��������ڣ�");
				}
				
				break;
			case 4:
				//ɾ������
				//1.����Ҫɾ���Ķ������
				System.out.println("********ɾ������********");
				System.out.print("������Ҫɾ���Ķ������");
				int delld=input.nextInt();
				int delindex=-1;//������¼��Ҫɾ���������±�
				boolean isdelfind=false;//��¼�Ƿ��ҵ���������
				//2.ѭ��������������
				for(int i=0;i<names.length;i++){
				//�ҵ����������������״̬��ִ��ɾ������(�ȼ�¼Ҫɾ���Ķ������)
					//��Ŵ�1��ʼ�ģ������±�=���-1
					if(names[i]!=null&&states[i]==1&&delld==i+1){
						delindex=i;
						isdelfind=true;
						break;
					
					//�ҵ�������������Ԥ��״̬����ʾ�޷�ɾ��
					}else if(names[i]!=null&&states[i]==0&&delld==i+1){
						System.out.println("��ѡ��Ķ���δǩ�ղ���ɾ��");
						isdelfind=true;
						break;
					}
				}
				//���û���ҵ��ö�������ʾδ�ҵ��ö���
				if(!isdelfind){
					System.out.println("�Բ��𣬴�������������!");
				}
				//ִ��ɾ������,ѭ����λ
				if(delindex!=-1){
					//��Ҫɾ������һ��Ԫ�ؿ�ʼ���������һ��Ԫ��������ǰ�ƶ�һλ,���һλ���
					for(int i=delindex+1;i<names.length;i++){
						names[i-1]=names[i];
						dishmegs[i-1]=dishmegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
					//���һλ���
					names[names.length-1]=null;
					dishmegs[dishmegs.length-1]=null;
					times[times.length-1]=0;
					addresses[addresses.length-1]=null;
					states[states.length-1]=0;
					
					System.out.println("����ɾ���ɹ���");
				}
				break;
			case 5:
				//��Ҫ����
				System.out.println("********��Ҫ����********");
				//1����ʾ�����޵Ĳ�Ʒ�б�
				System.out.println("���\t��Ʒ��\t����\t������");
				for(int j=0;j<dishnames.length;j++){
					String price=prices[j]+"Ԫ";
					String praise=praisenums[j]+"��";
					System.out.println((j+1)+"\t"+dishnames[j]+"\t"+price+"\t"+praise+"\t");
				}
				//2.����Ҫ���޵Ĳ�Ʒ��Ϣ
				System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishid=input.nextInt();
				//3.����ŵĵ�������һ
				praisenums[dishid-1]++;
				//��ʾ
				System.out.println("���޳ɹ���");
				System.out.println(dishnames[dishid-1]+" "+praisenums[dishid-1]+"��");
				
				break;
			case 6:
				//�˳�ϵͳ
				break;
			default:
				break;
				
			}
			//���û�����Ĺ��ܱ��Ϊ1-5֮�������,�˳�ѭ��,���򽫻���ʾ����0����
			if(choose<1||choose>5){
				break;
			}else{
			//��ʾ�û�����0����;
			System.out.print("����0����");
			num=input.nextInt();
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι���");
		
		
		
		
	}

}
