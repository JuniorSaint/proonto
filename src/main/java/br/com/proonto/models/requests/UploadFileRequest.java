package br.com.proonto.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UploadFileRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String creditor;
    private MultipartFile[] file;
}

