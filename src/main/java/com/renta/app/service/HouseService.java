//package com.renta.app.service;
//
//import java.util.stream.Collectors;
//
//import com.renta.app.repository.HouseFilesStorageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.renta.app.models.Houses;
//import com.renta.app.models.houseImage;
//import com.renta.app.repository.HouseRepository;
//
//@Service
//public class HouseService {
//
//	@Autowired
//	private HouseRepository houseRepository;
//	@Autowired
//	private HouseFilesStorageService housefileservice;
//	public Houses saveHouse(Houses house) {
//		Houses newHouse = new Houses();
//		newHouse.setCategory(house.getCategory());
//		newHouse.setRoomSize(house.getRoomSize());
//		newHouse.setPrice(house.getPrice());
//		newHouse.setLocation(house.getLocation());
//		newHouse.setDescription(house.getDescription());
//		newHouse.getHouseimage().addAll(house.getHouseimage()
//				.stream()
//				.map(v ->{
//					houseImage img = housefileservice.getFile(v.getId());
//					img.getHouses().add(newHouse);
//					return img;
//
//				}).collect(Collectors.toList()));
//		return houseRepository.save(newHouse);
//
//	}
//
//}
