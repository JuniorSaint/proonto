//package br.com.proonto.controllers;
//
//        import br.com.proonto.exceptions.ErrorUploadFileException;
//        import br.com.proonto.models.requests.UploadFileRequest;
//        import br.com.proonto.services.PignoraticsRuralBanknoteService;
//        import io.swagger.v3.oas.annotations.tags.Tag;
//        import lombok.AllArgsConstructor;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.*;
//        import org.springframework.web.multipart.MultipartFile;
//
//        import java.io.IOException;
//        import java.util.Objects;
//
//@RestController
//@RequestMapping(value = "/v1/upload", produces = {"application/json"})
//@CrossOrigin("*")
//@AllArgsConstructor
//@Tag(name = "Upload File", description = "Manager updaload file.")
//public class UploadFilesController {
//    private PignoraticsRuralBanknoteService saveFile;
//
//    @PostMapping
//    public ResponseEntity<String> uploadFile(@ModelAttribute UploadFileRequest files) throws IOException, InterruptedException {
//        try {
//            for (MultipartFile uploadedFile : files.getFile()) {
//                String pathFileUpload = String.valueOf(saveFile.uploadFile(uploadedFile));
//
//                if (pathFileUpload.equals("Error occurred while the file uploading")) {
//                    throw new ErrorUploadFileException("There was a problem to upload file try again or call the administrator");
//                }
//
//                String fileNameOriginal = new String(Objects.requireNonNull(uploadedFile.getOriginalFilename()));
//
//                if (fileNameOriginal.toLowerCase().contains("cliente")) {
//                    return    serviceCustomer.recordDataToDb(files.getIdDistributor(), pathFileUpload);
//                }
//
//                if (fileNameOriginal.toLowerCase().contains("sellout")) {
//                    serviceSellout.recordDataToDb(files.getIdDistributor(), pathFileUpload);
//                }
//                if (fileNameOriginal.toLowerCase().contains("equipamentos")) {
//                    serviceEquipment.recordDataToDb(files.getIdDistributor(), pathFileUpload);
//                }
//                if (fileNameOriginal.toLowerCase().contains("comodatos")) {
//                    serviceLending.recordDataToDb(files.getIdDistributor(), pathFileUpload);
//                }
//            }
//            return null;
////            return ResponseEntity.status(HttpStatus.OK).body("Upload of the file was successful");
//        } catch (BadRequestException e) {
//            throw new ErrorUploadFileException("There was a problem to upload file try again or call the administrator");
//        }
//    }
//}
//
