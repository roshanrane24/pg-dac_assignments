# **Q1** Explain what's inside each folder under '/'

- ## /bin

    `bin` directory contain essential binary files requred for all users.

- ## /boot

    `boot` directory contains files needed to boot the system.
It also contains Linux Kernel.

- ## /dev

    `dev` directory contains special files which represents actual or virtual devices

- ## /etc

    `etc` directory contains system wide configuration files which can be edited
    in any text editor.

- ## /home

    `home` directory usually contains home folder for each user.

- ## /lib

    `lib` directory contains libriaries needed by the essential binaries located
    in `bin` or `sbin` directory.

- ## /lib64

    `lib64` directory contains *64 bit* libriaries needed by the essential binaries
    located in `bin` or `sbin` directory.

- ## /mnt

    `mnt` directory is used temporary mounting file system.

- ## /media

    `media` directory is used for mount point of removable devices sunch as CD-ROMs.

- ## /opt

    `opt` directory contains subdirectories for optional third-party softwares.

- ## /proc

    `proc` directory contains special files that represents system & process information.

- ## /root

    `root` directory is home directory of the root user.

- ## /run

    `run` directory is standard directory to store temporary files which are not
    deleted over session restarts

- ## /sbin

    `sbin` directory stores the essential binaries that are intended to use by root
    user or super user.

- ## /srv

    `srv` directory contains data for services provided by the system eg. http server,
    ftp server.

- ## /sys

    `sys` directory contains files which provides information about devices connected
    to the system.

- ## /tmp

    `tmp` directory is use to store the temporary file which are deleted upon restarts.

- ## /usr

    `usr` directory contain application files, binary, libriaries used by users.

- ## /var

    `var` directory contains variable data files such as logs, databases.

# **Q2**  Tasks

## 1. Create 5 directories under /root/edac_os

``` sh
mkdir /root/edac_os
mkdir /root/edac_os/dir{1..5}
ls /root/edac_os/
```

## 2. Create the following files under each directory
dir1 --> file1, dir2 --> file2, dir3 --> file3, dir4 --> file4, dir5 --> file5

``` sh
touch /root/edac_os/dir1/file1
touch /root/edac_os/dir2/file2
touch /root/edac_os/dir3/file3
touch /root/edac_os/dir4/file4
touch /root/edac_os/dir5/file5
ls /root/edac_os/dir1
ls /root/edac_os/dir2
ls /root/edac_os/dir3
ls /root/edac_os/dir4
ls /root/edac_os/dir5
```

## 3. Create file6 and file7 under dir4

```sh
touch /root/edac_os/dir4/file{6..7}
ls /root/edac_os/dir4
```

## 4. Delete file1 under dir1

``` sh
rm -rf /root/edac_os/dir1/file1 
ls /root/edac_os/dir1/
```

## 5. Copy all files from dir4 to dir 1

``` sh
cp /root/edac_os/dir4/* /root/edac_os/dir1
ls /root/edac_os/dir1
```

## 6. Move all files from dir1 to dir2

``` sh
mv /root/edac_os/dir1/* /root/edac_os/dir2
ls /root/edac_os/dir1
ls /root/edac_os/dir2
```

## 7. Delete file1 from dir2

``` sh
rm -rf /root/edac_os/dir2/file1
ls /root/edac_os/dir2
```

## 8. Remove all the directories except dir2

``` sh
rm -rf /root/edac_os/dir1
rm -rf /root/edac_os/dir{3..5}
ls /root/edac_os/
```

## 9. Rename dir2 to fianldir

``` sh
mv /root/edac_os/dir2 /root/edac_os/finaldir
ls /root/edac_os/
```

## 10. list files under finaldir

``` sh
ls /root/edac_os/finaldir/
```

## 11. Each file under finaldir should have following content

I'm a file under finaldir

``` sh
vi /root/edac_os/finaldir/file1
vi /root/edac_os/finaldir/file2
vi /root/edac_os/finaldir/file3
vi /root/edac_os/finaldir/file4
vi /root/edac_os/finaldir/file6
vi /root/edac_os/finaldir/file7
cat /root/edac_os/finaldir/file1
cat /root/edac_os/finaldir/file2
cat /root/edac_os/finaldir/file3
cat /root/edac_os/finaldir/file4
cat /root/edac_os/finaldir/file6
cat /root/edac_os/finaldir/file7
```
