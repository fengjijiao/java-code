XposedBridge.hookAllMethods(ClassLoader.class, "loadClass", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                if (param.hasThrowable()) return;
                if (param.args.length != 1) return;

                Class<?> cls = (Class<?>) param.getResult();
                String name = cls.getName();
                if(name.startsWith("com.tencent.tbs.tbsshell.WebCoreProxy")) {
                    XposedBridge.log("找到类:" + name);
                    //dumpClass(cls);
                    XposedHelpers.findAndHookMethod(cls,
                            "getCookie",
                            String.class,boolean.class,
                            new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                    XposedBridge.log("HOOK住微信数据库插入操作。");
                                    String paramString1 = param.args[0].toString();
                                    String paramString2 = param.args[1].toString();
                                    XposedBridge.log("wx:"+paramString1+paramString2);
                                }
                            });
                    XposedHelpers.findAndHookMethod(cls,
                            "getCookie",
                            String.class,
                            new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                    XposedBridge.log("HOOK住微信数据库插入操作。");
                                    String paramString1 = param.args[0].toString();
                                    XposedBridge.log("wx:"+paramString1);
                                }
                            });
                    XposedHelpers.findAndHookMethod(cls,
                            "cookieManager_setCookie",
                            String.class, String.class,
                            new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                    XposedBridge.log("HOOK住微信数据库插入操作。");
                                    String paramString1 = (String) param.args[0];
                                    String paramString2 = (String) param.args[1];
                                    printInsertLog(paramString1, paramString2);
                                }
                            });
                }
            }
        });
