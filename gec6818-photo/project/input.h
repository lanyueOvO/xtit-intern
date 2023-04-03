#ifndef __INPUT_H__
#define __INPUT_H__

#include <linux/input.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/mman.h>
#include <stdlib.h>

#define RIGHT 1
#define LEFT 2
#define DOWN 3
#define UP 4 
#define DANJI 5

/*
    input_init：相关初始化
**/
int input_init();

/*
    input_end:相关销毁
**/
void input_end(int fd_i);

/*
    get_touch:获取触摸事件
    return:
        返回上、下、左、右、单击
**/
int get_touch(int fd);

#endif