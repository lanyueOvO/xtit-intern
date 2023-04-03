
/*
    input_init：相关初始化
**/
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
void get_touch()
{
    // 1.初始化
    int fd = input_init();

    // 获取文件中的信息 获取触摸事件的信息
    struct input_event ev;
    int x, y; // 保存触摸的坐标 最新的坐标 离开坐标
    int x0=-1, y0=-1; // 保存起始坐标
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
            x = ev.value;
        }
        else if(ev.type == EV_ABS && ev.code == ABS_Y)
        {
            // 只获取一次
            if(y0 == -1)
            {
                y0 = ev.value;
            }
            y = ev.value;
        }

        // 结束条件 BTN_TOUCH == 330
        if(ev.type == EV_KEY && ev.code == BTN_TOUCH && ev.value == 0)
        {
            break;
        }
    }
    
    printf("last:(%d, %d)\n", x, y);
    printf("first:(%d, %d)\n", x0, y0);

    // 判断手指上滑、下滑、左滑、右滑、单只因
    // 你的工作，实现滑动算法
    // ...

    // 收尾
    input_end(fd);
}


