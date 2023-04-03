/*
	bmp_show:显示一张bmp图片
	(x0, y0):图片显示的初始点
	bmpname:显示图片的路径名
**/
#include "bmp.h"
#include "lcd.h"
void bmp_show(int x0, int y0, char *bmpname)
{
	// 1.打开图片
	int fd_b = open(bmpname, O_RDWR);
	if(fd_b == -1 ) { perror("open bmp failed\n"); } 
	
	// 2.判断是否为bmp
	unsigned char buf[4] = {0}; // 用来保存读取到的数据
	read(fd_b, buf, 2);
	if(buf[0] != 0x42 || buf[1] != 0x4d)
	{
		perror("not bmp\n");
		return ;
	}
	
	// 3.获取图片的属性 宽度 高度 色深
	
	// 宽度 偏移量0x12 占4字节 
	lseek(fd_b, 0x12, SEEK_SET);
	read(fd_b, buf, 4);
	int width = buf[3] << 24 | buf[2] << 16 | buf[1] << 8 | buf[0] << 0; // 合成宽度
	
	// 高度 偏移量0x16 占4字节 
	lseek(fd_b, 0x16, SEEK_SET);
	read(fd_b, buf, 4);
	int height = buf[3] << 24 | buf[2] << 16 | buf[1] << 8 | buf[0] << 0; // 合成高度
	
	// 色深 偏移量0x1c 占2字节
	lseek(fd_b, 0x1c, SEEK_SET);
	read(fd_b, buf, 2);
	short depth = buf[1] << 8 | buf[0] << 0; // 合成色深
	
	// printf("width:%d\nheight:%d\ndepth:%d\n", width, height, depth);
	// 色深不为24/32
	if( !(depth==24 || depth==32))
	{
		printf("not 24/32\n");
		return ;
	}
	
	// 4.获取像素数组 			abs(x) 取x的绝对值
	int line_vaild_bytes = abs(width)*depth/8; // 理论上有效字节数 = 一行的像素点数*一个像素点占的字节数
	int line_bytes; // 一行实际上的字节数 = 一行的有效字节数 + “癞子”
	int laizi = 0;
	// 计算癞子数
	if(line_vaild_bytes % 4 != 0 )
	{
		laizi = 4 - line_vaild_bytes%4;
	}
	line_bytes = line_vaild_bytes + laizi;
	// 像素数组的大小 = 一行的实际字节数 * 多少行
	int all_bytes = line_vaild_bytes * abs(height);
	
	// 需要空间保存
	unsigned char data_buf[all_bytes];
	lseek(fd_b, 0x36, SEEK_SET);
	read(fd_b, data_buf, all_bytes);
	
	// printf("tttt\n");
	// 5.在开发板上显示图片
	unsigned char a, r, g, b;
	int color;
	int x, y;
	int i = 0;
	for(y=0; y<abs(height); y++) // 多少行
	{
		for(x=0; x<abs(width); x++) // 该行的第几个像素点
		{
			b = data_buf[i++];
			g = data_buf[i++];
			r = data_buf[i++];
			if(depth == 32) // 如果有a
			{
				a = data_buf[i++];
			}
			else // 没有a
			{
				a = 0;
			}
			
			color = (a << 24) | (r << 16) | (g << 8) | (b);
			lcd_point_show(width>0?x+x0:abs(width)-x-1+x0, 
					height>0?abs(height)-y-1+y0:y+y0, color); // 自己好好理解
		}
		i = i+laizi;
	}
	
	// 6.关闭文件
	close(fd_b);
}

// 5.项目要求
// 	一个菜单界面（包含两个功能按键）
// 		按键1 自动播放 至少六张
// 		按键2 手动播放 至少六张
		
// 项目框架：


// int main()
// {
//     // 1.lcd显示的初始化
//     int fd_lcd = lcd_init();
//     // 初始化触摸屏
//     int fd_i = input_init();
	
// 	char bmp_buf[][32] = {"1.bmp", "2.bmp", "3.bmp", "4.bmp", "5.bmp", "6.bmp"};
// 	char *p = &bmp_buf[0];
	
//     while(1)
//     {
// 		// 显示菜单界面
// 		...
// 		// 获取触摸事件
//         int touch = get_touch(fd_i);
// 		if(touch == ... )
// 		{
// 			// 自动播放
// 		}
// 		else if(touch == ... )
// 		{
// 			// 手动播放
// 		}
//     }


//     // 结束 进行相应收尾工作
//     lcd_end(fd_lcd);
//     // 收尾
//     input_end(fd_i);

// 	return 0;
// }