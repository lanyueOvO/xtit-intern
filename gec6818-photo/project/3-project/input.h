#ifndef __INPUT_H__
#define __INPUT_H__

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/mman.h>
#include <linux/input.h>
#include <stdlib.h>

int input_init();

void input_end(int fd_i);

int get_touch();


#endif



