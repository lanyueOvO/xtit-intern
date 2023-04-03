#include <stdio.h>
void main(){
    int year = 0;
    int mon = 0;
    int day = 0;
    int sum = 0;
    int er = 0;

    scanf("%d-%d-%d",&year,&mon,&day);
    switch (mon){
		case 1:sum = 0; break;
		case 2:sum = 31; break;
		case 3:sum = 59; break;
		case 4:sum = 90; break;
		case 5:sum = 120; break;
		case 6:sum = 151; break;
		case 7:sum = 181; break;
		case 8:sum = 212; break;
		case 9:sum = 243; break;
		case 10:sum = 273; break;
		case 11:sum = 304; break;
		case 12:sum = 334; break;
        
		default:printf("格式错误\n");
	}
	sum += day;
    if (year%4==0&&year%100!=0&&year%400!=0)
    {
        er = 1;
    }else{
        er = 0;
    }
    if (er == 1 && mon > 2) {
		sum += 1;
	}
	printf("这是%d年的第%d天\n", year, sum);
    
}