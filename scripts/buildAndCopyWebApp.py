#!/usr/local/bin/python3

import os
import shutil

while not os.getcwd().lower().endswith("stasbar-app"):
  os.chdir("..")

# subprocess.call(['yarn', '--cwd', 'frontend/', 'run', 'build'])
shutil.rmtree("backend/src/main/resources/assets/static/js")
os.system("cp -rf frontend/build/ backend/src/main/resources/assets/")
os.system("git add backend/src/main/resources/assets")
