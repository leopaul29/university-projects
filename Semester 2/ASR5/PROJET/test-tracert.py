#!/usr/bin/env python

from subprocess import Popen, PIPE
host='www.google.fr'
p = Popen(['tracert', host], stdout=PIPE)
while True:
    line = p.stdout.readline()
    print(line)
    if not line:
        break
