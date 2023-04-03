#include "lcd.h"
#include"bmp.h"
#include "input.h"
#include <string.h>
#include<pthread.h>


char * bmpname[] = {"1.bmp","5.bmp","6.bmp","3.bmp","4.bmp","2.bmp"};
// char * bmpname[] = {"1.bmp","2.bmp","3.bmp","4.bmp","5.bmp","6.bmp"};
int flag = 1;

int main(){
    int status = 0;
    int i = 0;
    lcd_init();
    // bool flag = true;
    

while (1)
{
    // 
    // bmp_show(0,0,bmpname[0]);
    // status = get_touch();
    // if (status==3)
    // {   
    //     bmp_show(0,0,bmpname[i]);
    //     i++;
    //     if (i>5)
    //     {
    //         i=0;
    //     }
        
    // }else if (status==4)
    // {
    //     i--;
    //     // strlen(bmpname)
    //     bmp_show(0,0,bmpname[i]);
    //     if (0==i)
    //     {
    //         i=5;
    //     }
    // }else if (status==0)
    // {
    //     for (int i = 0; i <= 5; i++)
    //     {
    //         sleep(1);
    //         bmp_show(0,0,bmpname[i]);
    //     }
        
    // }
            //  bmp_player(i);
        draw_rectangle(50,50,60,60,0x0000CD);
        status = get_touch();
        // printf("%d\n",status);
        if (3 == status)
        {
            if (5 == i)
            {
                i = 0;
            }
            else
                ++i;
            bmp_show(0,0,bmpname[i]);
            // bmp_player(i);
        }
        // show_bmp(bmpname[3],0,0);
        else if ( 4 == status)
        {
            if (0 > i)
            {
                i = 5;
            }
            else
                --i;
            // bmp_player(i);
            bmp_show(0,0,bmpname[i]);
        }
        else if (0==status)
        {
            flag = 1;
            while (1==flag)
            {
                printf("i1:%d\n",i);
                bmp_show(0,0,bmpname[i]);
                sleep(2); //原 1
                i++;
                if (6==i)
                {   
                    printf("i2:%d\n",i);
                    i=-1;
                    flag = 2;
                }
                
                printf("status0000:%d\n",flag);
            }
            
            printf("status3333:%d\n",status);
            
        }
        
    // status = 0;
    printf("status:%d\n",status);
}
    lcd_close();
}
