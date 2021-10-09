# esp32-wordclock

To erase the ESP32:
```
clj -A:erase
```

To bootstrap Espruino onto the ESP32:
```
clj -A:bootstrap
```

To compile the CLJS build: (You will probably need to change the WiFi settings in resources/build-secrets.edn)
```
clj -A:build
```

To create the ROM:
```
clj -A:rom
```

To flash the ROM to the ESP32:
```
clj -A:flash
```

To connect to the REPL: (You will probably need to change the endpoint address in resources/config.edn)
```
clj -A:repl
```