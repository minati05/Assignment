package com.assignment.service;

import java.io.*;
import org.springframework.stereotype.Service;
import com.assignment.model.ServiceRequest;

@Service
public class DeploymentService {

    public void process(ServiceRequest req) {

        String baseDir = "output/" + req.getServiceName();

        new File(baseDir + "/terraform").mkdirs();
        new File(baseDir + "/k8s").mkdirs();
        new File(baseDir + "/cicd").mkdirs();

        // Generate files
        createFromTemplate("templates/terraform/main.tf",
                baseDir + "/terraform/main.tf", req);

        createFromTemplate("templates/k8s/deployment.yaml",
                baseDir + "/k8s/deployment.yaml", req);

        createFromTemplate("templates/cicd/Jenkinsfile",
                baseDir + "/cicd/Jenkinsfile", req);
    }

    private void createFromTemplate(String templatePath, String outputPath, ServiceRequest req) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(templatePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Replace placeholders
            String finalContent = content.toString()
                    .replace("{{service_name}}", req.getServiceName())
                    .replace("{{repo_url}}", req.getRepoUrl())
                    .replace("{{ecr_repo_url}}", "123456789.dkr.ecr.ap-south-1.amazonaws.com/" + req.getServiceName());

            FileWriter writer = new FileWriter(outputPath);
            writer.write(finalContent);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}