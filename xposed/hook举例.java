                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(hookclass, "setCookie", String.class, String.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住setCookie操作。");
                                        String paramString1 = param.args[0].toString();
                                        String paramString2 = param.args[1].toString();
                                        XposedBridge.log(paramString1 + ":" + paramString2);
                                /*Bundle param2 = (Bundle) param.args[1];
                                String paramString2 = param2.toString();
                                printInsertLog(paramString1, paramString2);*/
                                    }
                                });
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(hookclass, "getCookie", String.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住getCookie操作。");
                                        String paramString1 = param.args[0].toString();
                                        XposedBridge.log(paramString1);
                                /*Bundle param2 = (Bundle) param.args[1];
                                String paramString2 = param2.toString();
                                printInsertLog(paramString1, paramString2);*/
                                    }
                                });
                    }
                }).start();
                final Class<?> WebViewUIClass;
                try {
                    WebViewUIClass = cl.loadClass("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                } catch (Exception e) {
                    XposedBridge.log("jyy"+"寻找com.tencent.mm.plugin.webview.ui.tools.WebViewUI报错"+e);
                    return;
                }
                XposedBridge.log("jyy"+"寻找com.tencent.mm.plugin.webview.ui.tools.WebViewUI成功");
                dumpClass(WebViewUIClass);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(WebViewUIClass, "startActivity", Intent.class, new XC_MethodHook() {
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                Intent intent = (Intent) param.args[0];
                                //String target = intent.getComponent().getClassName();
                                ToastUtils.showLong(intent.toString());
                                //Log.i(LOG_TAG + "-IntentTarget", target);
                        /*if (target.equals("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")
                                || target.equals("com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewTooLMpUI")
                                || target.equals("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewTooLMpUI")) {
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
                            intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        }*/
                            }
                        });
                    }
                }).start();
                final Class<?> SQLiteDatabaseClass;
                try {
                    SQLiteDatabaseClass = cl.loadClass("com.tencent.wcdb.database.SQLiteDatabase");
                } catch (Exception e) {
                    XposedBridge.log("jyy"+"寻找com.tencent.wcdb.database.SQLiteDatabase报错"+e);
                    return;
                }
                XposedBridge.log("jyy"+"寻找com.tencent.wcdb.database.SQLiteDatabase成功");
                dumpClass(SQLiteDatabaseClass);
                //eZp
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(SQLiteDatabaseClass, "insertWithOnConflict", String.class, String.class, ContentValues.class, int.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住insertWithOnConflict操作。");
                                        String paramString1 = (String) param.args[0];
                                        String paramString2 = (String) param.args[1];
                                        ContentValues contentValues = (ContentValues) param.args[2];
                                        //int paramString3 = (int) param.args[3];
                                        XposedBridge.log(paramString1 + ":" + paramString2 + ":" + contentValues);
                                        /*String tableName = (String) param.args[0];
                                        if (tableName == null || tableName.length() == 0 || contentValues == null) {
                                            return;
                                        }
                                        //过滤掉非聊天消息
                                        if (!tableName.equals("message")){
                                            return;
                                        }
                                        //提取消息内容
                                        //1：表示是自己发送的消息
                                        int isSend = contentValues.getAsInteger("isSend");
                                        //消息内容
                                        String strContent = contentValues.getAsString("content");
                                        //说话人ID
                                        String strTalker = contentValues.getAsString("talker");
                                        //收到消息，进行回复（要判断不是自己发送的、不是群消息、不是公众号消息，才回复）
                                        if (isSend != 1 && !strTalker.endsWith("@chatroom") && !strTalker.startsWith("gh_")) {
                                            replyTextMessage(plpparam, "wait a moment!" + strContent, strTalker);
                                        }*/
                                    }
                                });
                    }
                }).start();
                final Class<?> X5CookieManagerClass;
                try {
                    X5CookieManagerClass = cl.loadClass("com.tencent.xweb.x5.d");
                } catch (Exception e) {
                    XposedBridge.log("jyy" + "寻找com.tencent.xweb.x5.d报错" + e);
                    return;
                }
                XposedBridge.log("jyy" + "寻找com.tencent.xweb.x5.d成功");
                dumpClass(X5CookieManagerClass);
                //getCookie
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(X5CookieManagerClass, "getCookie", String.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住X5CookieManagerClass.getCookie操作。");
                                        String paramString1 = (String) param.args[0];
                                        XposedBridge.log("X5:" + paramString1);
                                        String result = (String) param.getResult();
                                        XposedBridge.log("X5:" + result);
                                    }
                                });
                    }
                }).start();
                //setCookie
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(X5CookieManagerClass, "setCookie", String.class, String.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住X5CookieManagerClass.setCookie操作。");
                                        String paramString1 = (String) param.args[0];
                                        String paramString2 = (String) param.args[1];
                                        XposedBridge.log("X5:" + paramString1 + ":" + paramString2);
                                    }
                                });
                    }
                }).start();
                final Class<?> CookieManagerClass;
                try {
                    CookieManagerClass = cl.loadClass("com.tencent.smtt.sdk.CookieManager");
                } catch (Exception e) {
                    XposedBridge.log("jyy" + "寻找com.tencent.smtt.sdk.CookieManager报错" + e);
                    return;
                }
                XposedBridge.log("jyy" + "寻找com.tencent.smtt.sdk.CookieManager成功");
                dumpClass(CookieManagerClass);
                //getCookie
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(CookieManagerClass, "getCookie", String.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住CookieManagerClass.getCookie操作。");
                                        String paramString1 = (String) param.args[0];
                                        XposedBridge.log("X:" + paramString1);
                                        String result = (String) param.getResult();
                                        XposedBridge.log("X:" + result);
                                    }
                                });
                    }
                }).start();
                //setCookie
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(CookieManagerClass, "setCookie", String.class, String.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住CookieManagerClass.setCookie操作。");
                                        String paramString1 = (String) param.args[0];
                                        String paramString2 = (String) param.args[1];
                                        XposedBridge.log("X:" + paramString1 + ":" + paramString2);
                                    }
                                });
                    }
                }).start();
                //setCookie
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        XposedHelpers.findAndHookMethod(CookieManagerClass, "setCookie", String.class, String.class, boolean.class,
                                new XC_MethodHook() {
                                    @Override
                                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                        XposedBridge.log("HOOK住CookieManagerClass.setCookie3操作。");
                                        String paramString1 = (String) param.args[0];
                                        String paramString2 = (String) param.args[1];
                                        XposedBridge.log("X:" + paramString1 + ":" + paramString2);
                                    }
                                });
                    }
                }).start();
