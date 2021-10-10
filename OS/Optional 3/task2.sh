 #!/bin/bash
 
 # Write a script that creates 1000 directories with 1000 files
 
 mkdir testdir
 cd testdir
 
 mkdir dir{1..100}
 
 for $dir in dir{1..100}
 do
 	touch $dir/file{1..100}
 done
