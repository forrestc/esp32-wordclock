# esp32-wordclock

To erase the ESP32:
```
clj -M:erase
```

To bootstrap Espruino onto the ESP32:
```
clj -M:bootstrap
```

To compile the CLJS build: (You will probably need to change the WiFi settings in resources/build-secrets.edn)
```
clj -M:build
```

To create the ROM:
```
clj -M:rom
```

To flash the ROM to the ESP32:
```
clj -M:flash
```

To connect to the REPL: (You will probably need to change the endpoint address in resources/config.edn)
```
clj -M:repl
```