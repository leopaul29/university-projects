#! /bin/bash

for BUFFSIZE in 512 1024 2048 4096 8192
do
	/usr/bin/time --format "%Uuser %Ssystem" ./inout2 $BUFFSIZE < BIGFOO  > foo
done

