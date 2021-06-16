# other-git

## 原理

### 

## config

### [credential] 

- helper = store

	- 记住密码

## git command

### 官方命令文档

### 非官方

### 常用命令

- git

	- --version
	- --help

- git config
- git add

	- -v, --verbose

		- 详细

- git commit

	- -m <msg>  --message=<msg>

		- Use the given <msg> as the commit message. If multiple -m options are given, their values are concatenated as separate paragraphs.

			- 多个分段

		- The -m option is mutually exclusive with -c, -C, and -F  

			- 互斥

	- -a 参数设置修改文件后不需要执行 git add 命令，直接来提交

- git push

	- git push <远程主机名> <本地分支名>:<远程分支名>

- git fetch
- git merge
- git pull

