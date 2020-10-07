### 安装过程中出现的问题

1.centos8默认使用podman代替docker，安装时会报错

Problem: package docker-ce-3:19.03.3-3.el7.x86_64 requires containerd.io >= 1.2.2-3, but none of the providers can be installed

### docker安装

```shell
1.卸载旧版本
$ sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
2.安装yum-utils软件包并设置稳定的储存库
$ sudo yum install -y yum-utils
3.添加镜像
$ sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
$ sudo yum-config-manager \
	--add-repo \
	http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
4.安装docker引擎
$ sudo yum install docker-ce docker-ce-cli containerd.io
5.启动docker
$ sudo systemctl start docker
```

