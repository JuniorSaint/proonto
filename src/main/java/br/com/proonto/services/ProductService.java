package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Product;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.models.requests.LocationProductionRequest;
import br.com.proonto.models.requests.ProductRequest;
import br.com.proonto.models.requests.RegistryRequest;
import br.com.proonto.models.responses.ProductResponseId;
import br.com.proonto.repositories.LocationProductionRepository;
import br.com.proonto.repositories.ProductRepository;
import br.com.proonto.repositories.RegistryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private LocationProdutionService locationService;
    @Autowired
    private RegistryService registryService;
    @Autowired
    private ImmovableService immovableService;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public ProductResponseId saveUpdate(ProductRequest request) {
        if (request.getId() != null) {
            ProductResponseId resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Product.class)), ProductResponseId.class);
    }

    public ProductResponseId findById(Long id) {
        Optional<Product> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Product" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, ProductResponseId.class);
    }
}
