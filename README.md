# SimpleServletProject
We have learned how to create web applications by using Jakarta and using the most popular features by implementing so we gained :
- How to use servlet (generic Servlet, http servlet) and extend it to create our concrete servlet class
- Know more about different scopes into our application (request, application, session)
- how to set and get init parameters in web.xml
- using jsp and jstl 
- using filters 
- how to upload and download different kind of file with different ways
- How to use Custom tags to handle custom bussiness into our jsp

## Setup Project config for this repo
1. Setup Database [Download Schema and db.properity](https://drive.google.com/file/d/10SdTY7gr8xcsaMcn9Yrsti2R7m_-CNXL/view?usp=share_link)
   1. import schema to your workBench
   2. SetUp db.properity file by adding schemaName, username and password
2. Modify tomcat plugin configration into pom.xml by changing user name, password, path
```
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
          <username>"enter user name"</username>
          <password>"enter password"</password>
          <url>"enter url"</url>
          <path>"enter path"</path>
        </configuration>
      </plugin>
```
3. Add file directories for uploading and downloading you will find it in TODO section 
