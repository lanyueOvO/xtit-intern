#include "lcd.h"

int *plcd = NULL; // 映射的全局变量
/*
    lcd_init:LCD的初始化
**/
int lcd_init()
{
    // 1.打开文件
    int fd = open("/dev/fb0", O_RDWR);
	if(fd == -1)
	{
		perror("open fb0 failed\n");
		return 0;
	}
	
	// 2.进行映射
	plcd = mmap(NULL, BUFSIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	if(plcd == NULL)
	{
		perror("mmap failed\n");
	}
    return fd;
}

/*
    LCD的销毁
**/
void lcd_end(int fd)
{
    // 解映射
	munmap(plcd, BUFSIZE);
	
	// 4.关闭文件
	close(fd);
}

/*
    lcd_point_show:给一个像素点上色
    （x，y）:指定(x, y)这个像素点
    color:上一个颜色
**/
void lcd_point_show(int x, int y, int color)
{
    // 限制画点的范围
    if(x>=0 && x<800 && y>=0 && y<480)
    {
        // 画一个点
        *(plcd + 800*y + x) = color;
    }
}

/*
    draw_rectangle:画一个矩形
    w:矩形的宽
    h:矩形的长
    (x0, y0):画矩形的初始点
    color:上的颜色
**/
void draw_rectangle(int x0, int y0, int h, int w, int color)
{
    int i, j;
    for(i=0; i<h; i++) // 第几行
    {
        for(j=0; j<w; j++) // 该行的第几个
        {
            lcd_point_show(j+x0, i+y0, color);
        }
    }
}

/*
    圆心(x0, y0) 半径 r
    draw_circle:画一个圆
    (x0, y0):确定一个圆心
    r：圆的半径
    color:上的颜色
**/
void draw_circle(int x0, int y0, int r, int color)
{
    int i, j;
    for(i=0; i<480; i++) // 第几行
    {
        for(j=0; j<800; j++) // 该行的第几个
        {
            // 如果不对 自己换一下
            if( ((j-x0)*(j-x0) + (i-y0)*(i-y0)) < r*r )
            {
                lcd_point_show(j, i, color);
            }
        }
    }
}

