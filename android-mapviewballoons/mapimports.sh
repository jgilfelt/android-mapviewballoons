#!/bin/bash

A_IMPORT="import com.amazon.geo.maps"
G_IMPORT="import com.google.android.maps"

A_VIEW="com.amazon.geo.maps.MapView"
G_VIEW="com.google.android.maps.MapView"

if [ "$1" = "a" ]; then
    FR=$G_IMPORT
    TO=$A_IMPORT
    FR1=$G_VIEW
    TO1=$A_VIEW
else
    FR=$A_IMPORT
    TO=$G_IMPORT
    FR1=$A_VIEW
    TO1=$G_VIEW
fi

find ./src -name "*.java" -print | xargs sed -i "" "s/$FR/$TO/g"
find ./res/layout -name "*.xml" -print | xargs sed -i "" "s/$FR1/$TO1/g"