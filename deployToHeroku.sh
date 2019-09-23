#!/usr/bin/env bash

origins=$(git remote show)
if [[ $origins != *"heroku"* ]]; then
    heroku git:remote -a stasbar-app
fi

heroku stack:set container --app stasbar-app && git push heroku master
