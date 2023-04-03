#ifndef __LCD_H__
#define __LCD_H__

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/mman.h>
#define BUFSIZE 800*480*4 // 宏定义 只是简单的文本替换

/*
    lcd_init:LCD的初始化
**/
int lcd_init();

/*
    LCD的销毁
**/
void lcd_end(int fd);

/*
    lcd_point_show:给一个像素点上色
    （x，y）:指定(x, y)这个像素点
    color:上一个颜色
**/
void lcd_point_show(int x, int y, int color);

/*
    draw_rectangle:画一个矩形
    w:矩形的宽
    h:矩形的长
    (x0, y0):画矩形的初始点
    color:上的颜色
**/
void draw_rectangle(int x0, int y0, int h, int w, int color);

/*
    圆心(x0, y0) 半径 r
    draw_circle:画一个圆
    (x0, y0):确定一个圆心
    r：圆的半径
    color:上的颜色
**/
void draw_circle(int x0, int y0, int r, int color);

#endif