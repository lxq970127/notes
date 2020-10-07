### 帮助命令

docker version： 显示docker 版本信息

docker info ：显示docker系统信息

docker help ：显示帮助指令

### 镜像命令

docker images： 显示所有的本地镜像 -a显示所有 -f过滤 -q显示镜像id

docker search <镜像名>： 搜索镜像 -f过滤

docker pull <镜像名>:tag 下载docker镜像 :tag指定版本

docker rmi ： 删除镜像 -f过滤

### 容器命令

docker run [可选参数]： image -name="name" 容器命名 -d 后台守护 -it使用交互方式运行，进入容器查看内容 -p指定容器端口

docker ps ：查看正在运行的容器

在容器内推出直接输入exit，不关闭退出容器ctrl+p+q

docker rm 容器id ：删除容器，无法删除正在运行的容器 -rf强制删除容器

docker start 容器id ：启动容器

docker restart 容器id：重启容器

docker stop容器id：停止容器

docker kill 容器id：强制停止容器

### 其他命令

docker logs  ：查看日志

docker top 容器id： 查看容器内部进程信息

docker inspect 容器id：查看容器元信息

docker exec -it 容器id：交互模式进入已启动的容器，开启一个新的终端

docker attach 容器id：交互模式进入已启动的容器，进入之前开启的终端

docker cp 容器id:/文件目录 主机路径：把docker内部的文件拷贝到主机

