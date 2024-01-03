package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/render")
public class RenderingController {

    private final ObjectRepository objectRepository;

    @Autowired
    public RenderingController(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @GetMapping
    public Flux<ObjectEntity> renderData(@RequestParam int width,
                                         @RequestParam int height,
                                         @RequestParam double minLat,
                                         @RequestParam double minLon,
                                         @RequestParam double maxLat,
                                         @RequestParam double maxLon) {
        // Реализация логики рендеринга данных
        // Используйте Project Reactor для асинхронных операций
        return objectRepository.findByGeometryWithin(minLat, minLon, maxLat, maxLon);
    }
}

