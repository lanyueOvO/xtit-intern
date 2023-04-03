#ifndef __LCD_H__
#define __LCD_H__

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/mman.h>
#define BUFSIZE 800*480*4 


int lcd_init();

void lcd_end(int fd);

void lcd_point_show(int x, int y, int color);

void draw_rectangle(int x0, int y0, int h, int w, int color);

void draw_circle(int x0, int y0, int r, int color);

void float_circle(int r, int size, int color);

void restart();

#endif
