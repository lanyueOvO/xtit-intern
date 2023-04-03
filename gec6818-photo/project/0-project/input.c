#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <strings.h>
#include <errno.h>
 
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <unistd.h>
#include <dirent.h>
#include "lcd.h"
#include <linux/input.h>


#define RIGHT 1
#define LEFT 2
#define DOWN 3
#define UP 4 
#define DANJI 5
/*
    input_init：相关初始化
**/
// draw_rectangle(int x0, int y0, int h, int w, int color);
int input_init()
{
    // 1.打开文件
    int fd_i = open("/dev/input/event0", O_RDWR);
    if(fd_i == -1)
    {
        perror("open event0 failed\n");
    }
}

/*
    input_end:相关销毁
**/
void input_end(int fd_i)
{
    close(fd_i);
}

/*
    get_touch:获取触摸事件
    return:
        返回上、下、左、右、单击
**/
int get_touch()
{
    // 1.初始化
    int fd = input_init();

    // 获取文件中的信息 获取触摸事件的信息
    struct input_event ev;
    int x, y; // 保存触摸的坐标 最新的坐标 离开坐标
    int x0=-1, y0=-1; // 保存起始坐标

	bool x_ready=false, y_ready=false;
    
    int pres = -1;
    while(1)
    {
        int ret = read(fd, &ev, sizeof(ev)); // sizeof(x) 计算x的大小并返回其大小值
        if(ret != sizeof(ev))
        {
            continue;
        }
        // 判断是否触摸
        if(ev.type == EV_ABS && ev.code == ABS_X)
        {
            // 只获取一次
            if(x0 == -1)
            {
                x0 = ev.value;
            }
            x_ready=true; 
            x = ev.value;
        }
        else if(ev.type == EV_ABS && ev.code == ABS_Y)
        {
            // 只获取一次
            if(y0 == -1)
            {
                y0 = ev.value;
            }
            y_ready=true;
            y = ev.value;
        }

        // 结束条件 BTN_TOUCH == 330
        if(ev.type == EV_KEY && ev.code == BTN_TOUCH && ev.value == 0)
        {   
            pres = ev.value;
            break;
        }

        if (x_ready && y_ready && pres==0)
        {
            return x,y;
        }
        
    }
    
    // printf("last:(%d, %d)\n", x, y);
    // printf("first:(%d, %d)\n", x0, y0);

    // 判断手指上滑、下滑、左滑、右滑、单只因
    // 你的工作，实现滑动算法
    // 
    // if (x-x0>0)
    // {
    //     printf("right\n");
    // }else
    // {
    //     printf("left\n");
    // }
    // if (y-y0>0)
    // {
    //     printf("down\n");
    // }else
    // {
    //     printf("down\n");
    // }
    // if (x==x0 && y==y0)
    // {
    //     printf("dan\n");
    // }
    if(x == x0 && y == y0)
    {
        printf("--------DANJI--------\n");
        draw_rectangle(120,120,150,150,0xFAEBD7);
        // return DANJI;
    }
    else if(abs(x-x0) > 2*abs(y-y0) )
    {
        // 左/右滑
        if(x-x0 < 0)
        {
            printf("--------LEFT--------\n");
            draw_rectangle(120,120,150,150,0xF0FFFF);
            // return LEFT;
        }
        else
        {
            printf("--------RIGHT--------\n");
            draw_rectangle(120,120,150,150,0xE0FFFF);
            // return RIGHT;
        }
    }
    else if(abs(y-y0) > 2*abs(x-x0))
    {
        if (y-y0<0)
        {
            printf("--------up--------\n");
            draw_rectangle(120,120,150,150,0x6B8E23);
            // return UP;
        }else
        {
            printf("--------down--------\n");
            draw_rectangle(120,120,150,150,0xA0522D);
            // return DOWN;
        }
        
    }
    // 收尾
    input_end(fd);
}
void main(){
    get_touch();
}
// void draw_rectangle(int x0, int y0, int h, int w, int color)
// {
//     int i, j;
//     for(i=0; i<h; i++) // 第几行
//     {
//         for(j=0; j<w; j++) // 该行的第几个
//         {
            
//             lcd_point_show(j+x0, i+y0, color);
//         }
//         sleep(0.1);
//     }
// }

