package com.example.inventory.controller;

import com.example.inventory.model.Inventory;
import com.example.inventory.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

  @Autowired
  private InventoryRepo inventoryRepo;

  @GetMapping("/add")
  public String showAddBookForm(Model model) {
    model.addAttribute("inventory", new Inventory());
    return "addInventory";
  }

  @PostMapping("/add")
  public String addInventory(Inventory inventory) {
    inventoryRepo.save(inventory);
    return "redirect:/inventory/list";
  }

  @GetMapping("/list")
  public String listInventory(Model model) {
    model.addAttribute("inventory", inventoryRepo.findAll());
    return "listInventory";
  }
}
