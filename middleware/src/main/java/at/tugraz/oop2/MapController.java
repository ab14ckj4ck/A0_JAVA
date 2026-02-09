package at.tugraz.oop2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class MapController {

    private List<Amenity> amenities = Arrays.asList(
            new Amenity("Casineum", 31625435, new Geom("Point", new double[]{15.4379613, 47.0699068}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "toilets:wheelchair", "yes",
                    "wheelchair", "yes",
                    "amenity", "theatre",
                    "name", "Casineum"
            ), "theatre"),
            new Amenity("Burgring Garage", 21261052, new Geom("Point", new double[]{15.4452594, 47.0708341}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "maxheight", "1.95",
                    "amenity", "parking_entrance",
                    "name", "Burgring Garage",
                    "vehicle", "yes"
            ), "parking_entrance"),
            new Amenity("Polizeiinspektion Schmiedgasse", 26899640, new Geom("Point", new double[]{15.4393231, 47.0686148}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "wheelchair", "yes",
                    "addr:housenumber", "26",
                    "phone", "+43 59133 6593 100",
                    "amenity", "police",
                    "addr:country", "AT",
                    "name", "Polizeiinspektion Schmiedgasse",
                    "addr:street", "Schmiedgasse",
                    "addr:postcode", "8010",
                    "addr:city", "Graz"
            ), "police"),
            new Amenity("", 289888353, new Geom("Point", new double[]{15.4429001, 47.0686097}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "collection_times", "Mo-Fr 17:00",
                    "amenity", "post_box",
                    "check_date:collection_times", "2022-04-13",
                    "addr:country", "AT",
                    "addr:street", "Hamerlinggasse",
                    "addr:postcode", "8010",
                    "operator", "Post",
                    "addr:city", "Graz"
            ), "post_box"),
            new Amenity("", 290161198, new Geom("Point", new double[]{15.4487617, 47.071778}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "amenity", "telephone",
                    "check_date", "2021-07-04",
                    "created_by", "Potlatch 0.10f"
            ), "telephone")
    );

    private List<Road> roads = Arrays.asList(
            new Road("Harrachgasse", 3997985, new Geom("LineString", new double[][]{{15.4452531, 47.0758469}, {15.4453456, 47.0758901}}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "sidewalk", "both",
                    "cycleway:both", "no",
                    "surface", "asphalt",
                    "lit", "yes",
                    "maxspeed", "30",
                    "name", "Harrachgasse",
                    "highway", "residential",
                    "name:etymology:wikidata", "Q689050",
                    "wikidata", "Q106635499",
                    "oneway", "yes"),
                    "residential", Arrays.asList(332085686L, 2921786347L)),
            new Road("Halbärthgasse", 3997987, new Geom("LineString", new double[][]{{15.4501904, 47.0761661}, {15.449979, 47.0763601}}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "sidewalk", "both",
                    "cycleway:both", "no",
                    "surface", "asphalt",
                    "lit", "yes",
                    "maxspeed", "20",
                    "name", "Halbärthgasse",
                    "highway", "residential",
                    "wikidata", "Q106635496",
                    "name:etymology", "Josef Halbärth (1762-1846)",
                    "name:start_date", "1844"),
                    "residential", Arrays.asList(20929609L, 1392830660L)),
            new Road("Alberstraße", 4014537, new Geom("LineString", new double[][]{{15.4514959, 47.0700555}, {15.4524184, 47.0697512}, {15.4524811, 47.0697243}}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "sidewalk", "both",
                    "surface", "asphalt",
                    "lit", "yes",
                    "maxspeed", "30",
                    "name", "Alberstraße",
                    "highway", "residential",
                    "name:etymology:wikidata", "Q106339916",
                    "wikidata", "Q106635435",
                    "name:etymology", "Albin Alber",
                    "name:start_date", "1860"),
                    "residential", Arrays.asList(1253038341L, 9607338715L, 21271819L)),
            new Road("Bürgergasse", 4014547, new Geom("LineString", new double[][]{{15.4429019, 47.0699889}, {15.4427947, 47.0701495}}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "bicycle", "yes",
                    "surface", "asphalt",
                    "lit", "yes",
                    "name", "Bürgergasse",
                    "highway", "pedestrian",
                    "wikidata", "Q106635458",
                    "name:start_date", "1785"),
                    "pedestrian", Arrays.asList(21298455L, 449291553L)),
            new Road("Rittergasse", 4399899, new Geom("LineString", new double[][]{{15.4464399, 47.0754936}, {15.445841, 47.0753454}, {15.4458303, 47.0753427}, {15.4457195, 47.0753152}}, new Crs("name", Map.of("name", "EPSG:0"))), Map.of(
                    "note", "blaue tafel -> cycleway",
                    "bicycle", "designated",
                    "surface", "cobblestone",
                    "name", "Rittergasse",
                    "highway", "cycleway",
                    "foot", "designated",
                    "segregated", "no"),
                    "cycleway", Arrays.asList(26899084L, 3871899917L, 3871899916L, 20929488L))
    );

    @GetMapping("/roads")
    public ResponseEntity<Wrapper> getRoads(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int take,
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(name = "bbox.tl.x", required = false) Double bbox_tl_x,
            @RequestParam(name = "bbox.tl.y", required = false) Double bbox_tl_y,
            @RequestParam(name = "bbox.br.x", required = false) Double bbox_br_x,
            @RequestParam(name = "bbox.br.y", required = false) Double bbox_br_y,
            @RequestParam(name = "point.x", required = false) Double point_x,
            @RequestParam(name = "point.y", required = false) Double point_y,
            @RequestParam(name = "point.d", required = false) Double point_d,
            @RequestParam(required = false) String road
    ) {
        if (roads == null || roads.isEmpty()) {
            throw new IllegalArgumentException("No roads found");
        }

        checkBoundaries(bbox_tl_x, bbox_tl_y, bbox_br_x, bbox_br_y, point_x, point_y, point_d);

        boolean bbox_provided = bbox_tl_x != null && bbox_tl_y != null && bbox_br_x != null && bbox_br_y != null;
        boolean point_provided = point_x != null && point_y != null && point_d != null;

        if (!bbox_provided && !point_provided) {
            Wrapper wrapper = new Wrapper(roads, new Paging(take, roads.size(), skip));
            MapLogger.backendLogRoadsRequest();
            return ResponseEntity.ok(wrapper);
        }

        /*List<Road> filtered_roads = roads;
        if (road != null && !road.isEmpty()) {
            filtered_roads = roads.stream().filter(r -> r.getTags().containsValue(road)).toList();
            if (filtered_roads.isEmpty()) {
                throw new ResourceNotFoundException("Road not found");
            } else if (filtered_roads != roads) {
                roads = filtered_roads;
            }
        }

        int start = skip + (page * take);
        int end = Math.min(start + take, roads.size());

        if (start >= roads.size()) {
            throw new IllegalArgumentException("Requested page not found");
        }

        List<Road> pagedRoads = roads.subList(start, end);
         */

        Wrapper wrapper = new Wrapper(roads, new Paging(take, roads.size(), skip));
        MapLogger.backendLogRoadsRequest();
        return ResponseEntity.ok(wrapper);
    }

    @GetMapping("/roads/{id}")
    public ResponseEntity<Road> findRoadById(@PathVariable Integer id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID out of range");
        }

        Road road = roads.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Road not found"));

        MapLogger.backendLogRoadRequest(id);
        return ResponseEntity.ok(road);
    }

    @GetMapping("/amenities")
    public ResponseEntity<Wrapper> getAmenity(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int take,
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(name = "bbox.tl.x", required = false) Double bbox_tl_x,
            @RequestParam(name = "bbox.tl.y", required = false) Double bbox_tl_y,
            @RequestParam(name = "bbox.br.x", required = false) Double bbox_br_x,
            @RequestParam(name = "bbox.br.y", required = false) Double bbox_br_y,
            @RequestParam(name = "point.x", required = false) Double point_x,
            @RequestParam(name = "point.y", required = false) Double point_y,
            @RequestParam(name = "point.d", required = false) Double point_d,
            @RequestParam(required = false) String amenity
    ) {
        if (amenities == null || amenities.isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments in URL (Empty / null)");
        }

        checkBoundaries(bbox_tl_x, bbox_tl_y, bbox_br_x, bbox_br_y, point_x, point_y, point_d);

        boolean bbox_provided = bbox_tl_x != null && bbox_tl_y != null && bbox_br_x != null && bbox_br_y != null;
        boolean point_provided = point_x != null && point_y != null && point_d != null;

        if (!bbox_provided && !point_provided) {
            Wrapper wrapper = new Wrapper(amenities, new Paging(take, amenities.size(), skip));
            MapLogger.backendLogAmenitiesRequest();
            return ResponseEntity.ok(wrapper);
        }

 /*       List<Amenity> filtered_amenities = amenities;
        if (amenity != null && !amenity.isEmpty()) {
            filtered_amenities = amenities.stream().filter(a -> a.getTags().containsValue(amenity)).toList();
        }

        int start = skip + (page * take);
        int end = Math.min(start + take, amenities.size());

        if (filtered_amenities != amenities) {
            amenities = filtered_amenities;
        }

        if (start > amenities.size()) {
            throw new IllegalArgumentException("Requested amenities page not found!");
        } else {
            List<Amenity> am_page = amenities.subList(start, end);
            Wrapper wrapper = new Wrapper(am_page, new Paging(take, amenities.size(), skip));
            MapLogger.backendLogAmenitiesRequest();
            return ResponseEntity.ok(wrapper);
        }

  */
        Wrapper wrapper = new Wrapper(amenities, new Paging(take, amenities.size(), skip));
        MapLogger.backendLogAmenitiesRequest();
        return ResponseEntity.ok(wrapper);
    }

    @GetMapping("/amenities/{id}")
    public ResponseEntity<Amenity> findAmenityById(@PathVariable Integer id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID out of range");
        }

        Amenity amenity = amenities.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Amenity not found"));

        MapLogger.backendLogAmenityRequest(id);
        return ResponseEntity.ok(amenity);
    }

    private void checkBoundaries(Double tl_x, Double tl_y, Double br_x, Double br_y, Double point_x, Double point_y, Double point_d) {
        boolean bbox_provided = tl_x != null || tl_y != null || br_x != null || br_y != null;
        boolean point_provided = point_x != null || point_y != null || point_d != null;

        if (bbox_provided && point_provided) {
            throw new IllegalArgumentException("Either Bounding Box or Point parameters must be provided.");
        }

        if (bbox_provided) {
            if ((tl_x == null || tl_y == null || br_x == null || br_y == null)) {
                throw new IllegalArgumentException("Missing arguments in URL");
            }
            if (tl_x < -180 || tl_x > 180 || tl_y < -90 || tl_y > 90 || br_x < -180 || br_x > 180 || br_y < -90 || br_y > 90 ||
                    tl_x > br_x || tl_y < br_y) {
                throw new IllegalArgumentException("Invalid Boundaries!");
            }
        } else if (point_provided) {
            if (point_x == null || point_y == null || point_d == null) {
                throw new IllegalArgumentException("Missing arguments in URL");
            }
            if (point_x < -180 || point_x > 180 || point_y < -90 || point_y > 90 || point_d < 0) {
                throw new IllegalArgumentException("Invalid point coordinates!");
            }
        }
    }
}

