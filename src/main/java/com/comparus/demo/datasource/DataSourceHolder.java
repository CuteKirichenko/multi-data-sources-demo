package com.comparus.demo.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@ConfigurationProperties(prefix = "spring")
public class DataSourceHolder {
    private List<DbSource> dataSources;

    public List<DbSource> getDataSources() {
        return dataSources;
    }

    public void setDataSources(List<DbSource> dataSources) {
        this.dataSources = dataSources;
    }

    public static class DbSource {
        private String name;
        private String strategy;
        private String url;
        private String table;
        private String user;
        private String password;
        private String driverClassName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStrategy() {
            return strategy;
        }

        public void setStrategy(String strategy) {
            this.strategy = strategy;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DbSource dbSource = (DbSource) o;
            return Objects.equals(name, dbSource.name) && Objects.equals(strategy, dbSource.strategy) && Objects.equals(url, dbSource.url) && Objects.equals(table, dbSource.table) && Objects.equals(user, dbSource.user) && Objects.equals(password, dbSource.password) && Objects.equals(driverClassName, dbSource.driverClassName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, strategy, url, table, user, password, driverClassName);
        }

        @Override
        public String toString() {
            return "DbSource{" +
                    "name='" + name + '\'' +
                    ", strategy='" + strategy + '\'' +
                    ", url='" + url + '\'' +
                    ", table='" + table + '\'' +
                    ", user='" + user + '\'' +
                    ", password='" + password + '\'' +
                    ", driverClassName='" + driverClassName + '\'' +
                    '}';
        }
    }

    public List<String> getDbNames(){
        return this.dataSources.stream().map(DbSource::getName).toList();
    }
}
