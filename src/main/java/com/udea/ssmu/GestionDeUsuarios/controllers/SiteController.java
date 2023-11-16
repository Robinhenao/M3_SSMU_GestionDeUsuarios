package com.udea.ssmu.GestionDeUsuarios.controllers;

import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteData;
import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.dominio.site.interfaces.SiteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sites")
@CrossOrigin("*")
public class SiteController {

    private SiteService siteService;

    public SiteController(SiteService siteService){
        this.siteService = siteService;
    }


    @GetMapping("/byUser/{userCode}")
    public ResponseEntity<List<SiteData>> getSitesByUser(@PathVariable Long userCode){
        return ResponseEntity.ok().body(this.siteService.getSitesByUser(userCode));
    }

    @DeleteMapping("/{siteCode}")
    public ResponseEntity deleteSite(@PathVariable Long siteCode){
        this.siteService.deleteSite(siteCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{siteCode}")
    public ResponseEntity<SiteData> getSite(@PathVariable Long siteCode){
        return ResponseEntity.ok().body(this.siteService.getSite(siteCode));
    }

    @PostMapping
    public ResponseEntity<SiteData> registerSite(@RequestBody @Valid SiteRegistrationData siteRegistrationData, UriComponentsBuilder uriComponentsBuilder){
        SiteData site = this.siteService.registerSite(siteRegistrationData);
        URI uri = uriComponentsBuilder.path("/sites/{siteCode}").buildAndExpand(site.siteCode()).toUri();
        return ResponseEntity.created(uri).body(site);
    }


}
