package moudle;

import java.util.List;

public class TranslateBean {

    /**
     * web : [{"value":["好","善","商品"],"key":"Good"},{"value":["公共物品","公益事业","公共财"],"key":"public good"},{"value":["干的出色","干得好","好工作"],"key":"Good Job"}]
     * query : good
     * translation : ["很好"]
     * errorCode : 0
     * dict : {"url":"yddict://m.youdao.com/dict?le=eng&q=good"}
     * webdict : {"url":"http://m.youdao.com/dict?le=eng&q=good"}
     * basic : {"us-phonetic":"ɡʊd","phonetic":"gʊd","uk-phonetic":"gʊd","explains":["n. 好处；善行；慷慨的行为","adj. 好的；优良的；愉快的；虔诚的","adv. 好","n. (Good)人名；(英)古德；(瑞典)戈德"]}
     * l : EN2zh-CHS
     */

    private String query;
    private String errorCode;
    private DictBean dict;
    private WebdictBean webdict;
    private BasicBean basic;
    private String l;
    private List<WebBean> web;
    private List<String> translation;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public DictBean getDict() {
        return dict;
    }

    public void setDict(DictBean dict) {
        this.dict = dict;
    }

    public WebdictBean getWebdict() {
        return webdict;
    }

    public void setWebdict(WebdictBean webdict) {
        this.webdict = webdict;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public static class DictBean {
        /**
         * url : yddict://m.youdao.com/dict?le=eng&q=good
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class WebdictBean {
        /**
         * url : http://m.youdao.com/dict?le=eng&q=good
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class BasicBean {
        /**
         * us-phonetic : ɡʊd
         * phonetic : gʊd
         * uk-phonetic : gʊd
         * explains : ["n. 好处；善行；慷慨的行为","adj. 好的；优良的；愉快的；虔诚的","adv. 好","n. (Good)人名；(英)古德；(瑞典)戈德"]
         */

        @com.google.gson.annotations.SerializedName("us-phonetic")
        private String usphonetic;
        private String phonetic;
        @com.google.gson.annotations.SerializedName("uk-phonetic")
        private String ukphonetic;
        private List<String> explains;

        public String getUsphonetic() {
            return usphonetic;
        }

        public void setUsphonetic(String usphonetic) {
            this.usphonetic = usphonetic;
        }

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public String getUkphonetic() {
            return ukphonetic;
        }

        public void setUkphonetic(String ukphonetic) {
            this.ukphonetic = ukphonetic;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }
    }

    public static class WebBean {
        /**
         * value : ["好","善","商品"]
         * key : Good
         */

        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}

