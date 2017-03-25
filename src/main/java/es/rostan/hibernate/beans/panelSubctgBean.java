package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.caracteristicaDAO;
import es.rostan.hibernate.dao.matrizReferencialDAO;
import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.subcategoria;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 16/02/2017.
 */
@ManagedBean
public class panelSubctgBean {

    private List<caracteristica> lstCaracteristicas = new ArrayList<caracteristica>();

//    Listas de caracteristicas por subcategoria

    private List<caracteristica> lstCrcTechnology = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcDimensions = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcWeight = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcSim = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcType = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcSize = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcResolution = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcMultiTouch = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcProtection = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcOs = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcChipset = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcCpu = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcGpu = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcCardslot = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcInternal = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcPrimary = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcFeatures = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcVideo = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcSecondary = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcAlerts = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcLoudspeaker = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcJack = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcWlan = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcBlue = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcGps = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcRadio = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcUsb = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcOther = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcTalktime = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcMusicplay = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcBatteryType = new ArrayList<caracteristica>();

//    Lista de caracteristicas escogidas por su subcategoria

    private List<caracteristica> lstCrcTechnologySelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcDimensionsSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcWeightSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcSimSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcTypeSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcSizeSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcResolutionSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcMultiTouchSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcProtectionSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcOsSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcChipsetSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcCpuSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcGpuSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcCardslotSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcInternalSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcPrimarySelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcFeaturesSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcVideoSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcSecondarySelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcAlertsSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcLoudspeakerSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcJackSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcWlanSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcBlueSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcGpsSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcRadioSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcUsbSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcOtherSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcTalktimeSelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcMusicplaySelect = new ArrayList<caracteristica>();

    private List<caracteristica> lstCrcBatteryTypeSelect = new ArrayList<caracteristica>();

//    METODOS

    public void cargaMenus(app a){
        this.loadLstCrcTech(a);
        this.loadLstCrcDimensions(a);
        this.loadLstCrcWeight(a);
        this.loadLstCrcSim(a);
        this.loadLstCrcType(a);
        this.loadLstCrcSize(a);
        this.loadLstCrcResolution(a);
        this.loadLstCrcMultiTouch(a);
        this.loadLstCrcProtection(a);
        this.loadLstCrcOs(a);
        this.loadLstCrcChipset(a);
        this.loadLstCrcCpu(a);
        this.loadLstCrcGpu(a);
        this.loadLstCrcCardslot(a);
        this.loadLstCrcInternal(a);
        this.loadLstCrcPrimary(a);
        this.loadLstCrcFeatures(a);
        this.loadLstCrcVideo(a);
        this.loadLstCrcSecondary(a);
        this.loadLstCrcAlert(a);
        this.loadLstCrcLoudspeaker(a);
        this.loadLstCrcJack(a);
        this.loadLstCrcWlan(a);
        this.loadLstCrcBlue(a);
        this.loadLstCrcGps(a);
        this.loadLstCrcRadio(a);
        this.loadLstCrcUsb(a);
        this.loadLstCrcOther(a);
        this.loadLstCrcTalkTime(a);
        this.loadLstCrcMusicplay(a);
        this.loadLstCrcBatteryType(a);
    }

    private void loadLstCrcTech(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcTechnology = md.searchCrcXSubApp(1L, a);
    }

    private void loadLstCrcDimensions(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcDimensions = md.searchCrcXSubApp(2L, a);
    }

    private void loadLstCrcWeight(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcWeight = md.searchCrcXSubApp(3L, a);
    }

    private void loadLstCrcSim(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcSim = md.searchCrcXSubApp(4L, a);
    }

    private void loadLstCrcType(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcType = md.searchCrcXSubApp(5L, a);
    }

    private void loadLstCrcSize(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcSize = md.searchCrcXSubApp(6L, a);
    }

    private void loadLstCrcResolution(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcResolution = md.searchCrcXSubApp(7L, a);
    }

    private void loadLstCrcMultiTouch(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcMultiTouch = md.searchCrcXSubApp(8L, a);
    }

    private void loadLstCrcProtection(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcProtection = md.searchCrcXSubApp(9L, a);
    }

    private void loadLstCrcOs(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcOs = md.searchCrcXSubApp(10L, a);
    }

    private void loadLstCrcChipset(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcChipset = md.searchCrcXSubApp(11L, a);
    }

    private void loadLstCrcCpu(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcCpu = md.searchCrcXSubApp(12L, a);
    }

    private void loadLstCrcGpu(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcGpu = md.searchCrcXSubApp(13L, a);
    }

    private void loadLstCrcCardslot(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcCardslot = md.searchCrcXSubApp(14L, a);
    }

    private void loadLstCrcInternal(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcInternal = md.searchCrcXSubApp(15L, a);
    }

    private void loadLstCrcPrimary(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcPrimary = md.searchCrcXSubApp(16L, a);
    }

    private void loadLstCrcFeatures(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcFeatures = md.searchCrcXSubApp(17L, a);
    }

    private void loadLstCrcVideo(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcVideo = md.searchCrcXSubApp(18L, a);
    }

    private void loadLstCrcSecondary(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcSecondary = md.searchCrcXSubApp(19L, a);
    }

    private void loadLstCrcAlert(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcAlerts = md.searchCrcXSubApp(20L, a);
    }

    private void loadLstCrcLoudspeaker(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcLoudspeaker = md.searchCrcXSubApp(21L, a);
    }

    private void loadLstCrcJack(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcJack = md.searchCrcXSubApp(22L, a);
    }

    private void loadLstCrcWlan(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcWlan = md.searchCrcXSubApp(23L, a);
    }

    private void loadLstCrcBlue(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcBlue = md.searchCrcXSubApp(24L, a);
    }

    private void loadLstCrcGps(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcGps = md.searchCrcXSubApp(25L, a);
    }

    private void loadLstCrcRadio(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcRadio = md.searchCrcXSubApp(26L, a);
    }

    private void loadLstCrcUsb(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcUsb = md.searchCrcXSubApp(27L, a);
    }

    private void loadLstCrcOther(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcOther = md.searchCrcXSubApp(28L, a);
    }

    private void loadLstCrcTalkTime(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcTalktime = md.searchCrcXSubApp(29L, a);
    }

    private void loadLstCrcMusicplay(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcMusicplay = md.searchCrcXSubApp(30L, a);
    }

    private void loadLstCrcBatteryType(app a){
        matrizReferencialDAO md = new matrizReferencialDAO();
        this.lstCrcBatteryType = md.searchCrcXSubApp(31L, a);
    }

//    GETTER Y SETTERS
    public List<caracteristica> getLstCaracteristicas() {
        return lstCaracteristicas;
    }

    public void setLstCaracteristicas(List<caracteristica> lstCaracteristicas) {
        this.lstCaracteristicas = lstCaracteristicas;
    }

    public List<caracteristica> getLstCrcTechnology() {
        return lstCrcTechnology;
    }

    public void setLstCrcTechnology(List<caracteristica> lstCrcTechnology) {
        this.lstCrcTechnology = lstCrcTechnology;
    }

    public List<caracteristica> getLstCrcDimensions() {
        return lstCrcDimensions;
    }

    public void setLstCrcDimensions(List<caracteristica> lstCrcDimensions) {
        this.lstCrcDimensions = lstCrcDimensions;
    }

    public List<caracteristica> getLstCrcWeight() {
        return lstCrcWeight;
    }

    public void setLstCrcWeight(List<caracteristica> lstCrcWeight) {
        this.lstCrcWeight = lstCrcWeight;
    }

    public List<caracteristica> getLstCrcSim() {
        return lstCrcSim;
    }

    public void setLstCrcSim(List<caracteristica> lstCrcSim) {
        this.lstCrcSim = lstCrcSim;
    }

    public List<caracteristica> getLstCrcTechnologySelect() {
        return lstCrcTechnologySelect;
    }

    public void setLstCrcTechnologySelect(List<caracteristica> lstCrcTechnologySelect) {
        this.lstCrcTechnologySelect = lstCrcTechnologySelect;
    }

    public List<caracteristica> getLstCrcDimensionsSelect() {
        return lstCrcDimensionsSelect;
    }

    public void setLstCrcDimensionsSelect(List<caracteristica> lstCrcDimensionsSelect) {
        this.lstCrcDimensionsSelect = lstCrcDimensionsSelect;
    }

    public List<caracteristica> getLstCrcWeightSelect() {
        return lstCrcWeightSelect;
    }

    public void setLstCrcWeightSelect(List<caracteristica> lstCrcWeightSelect) {
        this.lstCrcWeightSelect = lstCrcWeightSelect;
    }

    public List<caracteristica> getLstCrcSimSelect() {
        return lstCrcSimSelect;
    }

    public void setLstCrcSimSelect(List<caracteristica> lstCrcSimSelect) {
        this.lstCrcSimSelect = lstCrcSimSelect;
    }

    public List<caracteristica> getLstCrcType() {
        return lstCrcType;
    }

    public void setLstCrcType(List<caracteristica> lstCrcType) {
        this.lstCrcType = lstCrcType;
    }

    public List<caracteristica> getLstCrcTypeSelect() {
        return lstCrcTypeSelect;
    }

    public void setLstCrcTypeSelect(List<caracteristica> lstCrcTypeSelect) {
        this.lstCrcTypeSelect = lstCrcTypeSelect;
    }

    public List<caracteristica> getLstCrcSize() {
        return lstCrcSize;
    }

    public void setLstCrcSize(List<caracteristica> lstCrcSize) {
        this.lstCrcSize = lstCrcSize;
    }

    public List<caracteristica> getLstCrcSizeSelect() {
        return lstCrcSizeSelect;
    }

    public void setLstCrcSizeSelect(List<caracteristica> lstCrcSizeSelect) {
        this.lstCrcSizeSelect = lstCrcSizeSelect;
    }

    public List<caracteristica> getLstCrcResolution() {
        return lstCrcResolution;
    }

    public void setLstCrcResolution(List<caracteristica> lstCrcResolution) {
        this.lstCrcResolution = lstCrcResolution;
    }

    public List<caracteristica> getLstCrcMultiTouch() {
        return lstCrcMultiTouch;
    }

    public void setLstCrcMultiTouch(List<caracteristica> lstCrcMultiTouch) {
        this.lstCrcMultiTouch = lstCrcMultiTouch;
    }

    public List<caracteristica> getLstCrcProtection() {
        return lstCrcProtection;
    }

    public void setLstCrcProtection(List<caracteristica> lstCrcProtection) {
        this.lstCrcProtection = lstCrcProtection;
    }

    public List<caracteristica> getLstCrcOs() {
        return lstCrcOs;
    }

    public void setLstCrcOs(List<caracteristica> lstCrcOs) {
        this.lstCrcOs = lstCrcOs;
    }

    public List<caracteristica> getLstCrcResolutionSelect() {
        return lstCrcResolutionSelect;
    }

    public void setLstCrcResolutionSelect(List<caracteristica> lstCrcResolutionSelect) {
        this.lstCrcResolutionSelect = lstCrcResolutionSelect;
    }

    public List<caracteristica> getLstCrcMultiTouchSelect() {
        return lstCrcMultiTouchSelect;
    }

    public void setLstCrcMultiTouchSelect(List<caracteristica> lstCrcMultiTouchSelect) {
        this.lstCrcMultiTouchSelect = lstCrcMultiTouchSelect;
    }

    public List<caracteristica> getLstCrcProtectionSelect() {
        return lstCrcProtectionSelect;
    }

    public void setLstCrcProtectionSelect(List<caracteristica> lstCrcProtectionSelect) {
        this.lstCrcProtectionSelect = lstCrcProtectionSelect;
    }

    public List<caracteristica> getLstCrcOsSelect() {
        return lstCrcOsSelect;
    }

    public void setLstCrcOsSelect(List<caracteristica> lstCrcOsSelect) {
        this.lstCrcOsSelect = lstCrcOsSelect;
    }

    public List<caracteristica> getLstCrcChipset() {
        return lstCrcChipset;
    }

    public void setLstCrcChipset(List<caracteristica> lstCrcChipset) {
        this.lstCrcChipset = lstCrcChipset;
    }

    public List<caracteristica> getLstCrcChipsetSelect() {
        return lstCrcChipsetSelect;
    }

    public void setLstCrcChipsetSelect(List<caracteristica> lstCrcChipsetSelect) {
        this.lstCrcChipsetSelect = lstCrcChipsetSelect;
    }

    public List<caracteristica> getLstCrcCpu() {
        return lstCrcCpu;
    }

    public void setLstCrcCpu(List<caracteristica> lstCrcCpu) {
        this.lstCrcCpu = lstCrcCpu;
    }

    public List<caracteristica> getLstCrcGpu() {
        return lstCrcGpu;
    }

    public void setLstCrcGpu(List<caracteristica> lstCrcGpu) {
        this.lstCrcGpu = lstCrcGpu;
    }

    public List<caracteristica> getLstCrcCardslot() {
        return lstCrcCardslot;
    }

    public void setLstCrcCardslot(List<caracteristica> lstCrcCardslot) {
        this.lstCrcCardslot = lstCrcCardslot;
    }

    public List<caracteristica> getLstCrcInternal() {
        return lstCrcInternal;
    }

    public void setLstCrcInternal(List<caracteristica> lstCrcInternal) {
        this.lstCrcInternal = lstCrcInternal;
    }

    public List<caracteristica> getLstCrcPrimary() {
        return lstCrcPrimary;
    }

    public void setLstCrcPrimary(List<caracteristica> lstCrcPrimary) {
        this.lstCrcPrimary = lstCrcPrimary;
    }

    public List<caracteristica> getLstCrcFeatures() {
        return lstCrcFeatures;
    }

    public void setLstCrcFeatures(List<caracteristica> lstCrcFeatures) {
        this.lstCrcFeatures = lstCrcFeatures;
    }

    public List<caracteristica> getLstCrcVideo() {
        return lstCrcVideo;
    }

    public void setLstCrcVideo(List<caracteristica> lstCrcVideo) {
        this.lstCrcVideo = lstCrcVideo;
    }

    public List<caracteristica> getLstCrcSecondary() {
        return lstCrcSecondary;
    }

    public void setLstCrcSecondary(List<caracteristica> lstCrcSecondary) {
        this.lstCrcSecondary = lstCrcSecondary;
    }

    public List<caracteristica> getLstCrcAlerts() {
        return lstCrcAlerts;
    }

    public void setLstCrcAlerts(List<caracteristica> lstCrcAlerts) {
        this.lstCrcAlerts = lstCrcAlerts;
    }

    public List<caracteristica> getLstCrcLoudspeaker() {
        return lstCrcLoudspeaker;
    }

    public void setLstCrcLoudspeaker(List<caracteristica> lstCrcLoudspeaker) {
        this.lstCrcLoudspeaker = lstCrcLoudspeaker;
    }

    public List<caracteristica> getLstCrcJack() {
        return lstCrcJack;
    }

    public void setLstCrcJack(List<caracteristica> lstCrcJack) {
        this.lstCrcJack = lstCrcJack;
    }

    public List<caracteristica> getLstCrcWlan() {
        return lstCrcWlan;
    }

    public void setLstCrcWlan(List<caracteristica> lstCrcWlan) {
        this.lstCrcWlan = lstCrcWlan;
    }

    public List<caracteristica> getLstCrcBlue() {
        return lstCrcBlue;
    }

    public void setLstCrcBlue(List<caracteristica> lstCrcBlue) {
        this.lstCrcBlue = lstCrcBlue;
    }

    public List<caracteristica> getLstCrcGps() {
        return lstCrcGps;
    }

    public void setLstCrcGps(List<caracteristica> lstCrcGps) {
        this.lstCrcGps = lstCrcGps;
    }

    public List<caracteristica> getLstCrcRadio() {
        return lstCrcRadio;
    }

    public void setLstCrcRadio(List<caracteristica> lstCrcRadio) {
        this.lstCrcRadio = lstCrcRadio;
    }

    public List<caracteristica> getLstCrcUsb() {
        return lstCrcUsb;
    }

    public void setLstCrcUsb(List<caracteristica> lstCrcUsb) {
        this.lstCrcUsb = lstCrcUsb;
    }

    public List<caracteristica> getLstCrcOther() {
        return lstCrcOther;
    }

    public void setLstCrcOther(List<caracteristica> lstCrcOther) {
        this.lstCrcOther = lstCrcOther;
    }

    public List<caracteristica> getLstCrcTalktime() {
        return lstCrcTalktime;
    }

    public void setLstCrcTalktime(List<caracteristica> lstCrcTalktime) {
        this.lstCrcTalktime = lstCrcTalktime;
    }

    public List<caracteristica> getLstCrcMusicplay() {
        return lstCrcMusicplay;
    }

    public void setLstCrcMusicplay(List<caracteristica> lstCrcMusicplay) {
        this.lstCrcMusicplay = lstCrcMusicplay;
    }

    public List<caracteristica> getLstCrcBatteryType() {
        return lstCrcBatteryType;
    }

    public void setLstCrcBatteryType(List<caracteristica> lstCrcBatteryType) {
        this.lstCrcBatteryType = lstCrcBatteryType;
    }

    public List<caracteristica> getLstCrcCpuSelect() {
        return lstCrcCpuSelect;
    }

    public void setLstCrcCpuSelect(List<caracteristica> lstCrcCpuSelect) {
        this.lstCrcCpuSelect = lstCrcCpuSelect;
    }

    public List<caracteristica> getLstCrcGpuSelect() {
        return lstCrcGpuSelect;
    }

    public void setLstCrcGpuSelect(List<caracteristica> lstCrcGpuSelect) {
        this.lstCrcGpuSelect = lstCrcGpuSelect;
    }

    public List<caracteristica> getLstCrcCardslotSelect() {
        return lstCrcCardslotSelect;
    }

    public void setLstCrcCardslotSelect(List<caracteristica> lstCrcCardslotSelect) {
        this.lstCrcCardslotSelect = lstCrcCardslotSelect;
    }

    public List<caracteristica> getLstCrcInternalSelect() {
        return lstCrcInternalSelect;
    }

    public void setLstCrcInternalSelect(List<caracteristica> lstCrcInternalSelect) {
        this.lstCrcInternalSelect = lstCrcInternalSelect;
    }

    public List<caracteristica> getLstCrcPrimarySelect() {
        return lstCrcPrimarySelect;
    }

    public void setLstCrcPrimarySelect(List<caracteristica> lstCrcPrimarySelect) {
        this.lstCrcPrimarySelect = lstCrcPrimarySelect;
    }

    public List<caracteristica> getLstCrcFeaturesSelect() {
        return lstCrcFeaturesSelect;
    }

    public void setLstCrcFeaturesSelect(List<caracteristica> lstCrcFeaturesSelect) {
        this.lstCrcFeaturesSelect = lstCrcFeaturesSelect;
    }

    public List<caracteristica> getLstCrcVideoSelect() {
        return lstCrcVideoSelect;
    }

    public void setLstCrcVideoSelect(List<caracteristica> lstCrcVideoSelect) {
        this.lstCrcVideoSelect = lstCrcVideoSelect;
    }

    public List<caracteristica> getLstCrcSecondarySelect() {
        return lstCrcSecondarySelect;
    }

    public void setLstCrcSecondarySelect(List<caracteristica> lstCrcSecondarySelect) {
        this.lstCrcSecondarySelect = lstCrcSecondarySelect;
    }

    public List<caracteristica> getLstCrcAlertsSelect() {
        return lstCrcAlertsSelect;
    }

    public void setLstCrcAlertsSelect(List<caracteristica> lstCrcAlertsSelect) {
        this.lstCrcAlertsSelect = lstCrcAlertsSelect;
    }

    public List<caracteristica> getLstCrcLoudspeakerSelect() {
        return lstCrcLoudspeakerSelect;
    }

    public void setLstCrcLoudspeakerSelect(List<caracteristica> lstCrcLoudspeakerSelect) {
        this.lstCrcLoudspeakerSelect = lstCrcLoudspeakerSelect;
    }

    public List<caracteristica> getLstCrcJackSelect() {
        return lstCrcJackSelect;
    }

    public void setLstCrcJackSelect(List<caracteristica> lstCrcJackSelect) {
        this.lstCrcJackSelect = lstCrcJackSelect;
    }

    public List<caracteristica> getLstCrcWlanSelect() {
        return lstCrcWlanSelect;
    }

    public void setLstCrcWlanSelect(List<caracteristica> lstCrcWlanSelect) {
        this.lstCrcWlanSelect = lstCrcWlanSelect;
    }

    public List<caracteristica> getLstCrcBlueSelect() {
        return lstCrcBlueSelect;
    }

    public void setLstCrcBlueSelect(List<caracteristica> lstCrcBlueSelect) {
        this.lstCrcBlueSelect = lstCrcBlueSelect;
    }

    public List<caracteristica> getLstCrcGpsSelect() {
        return lstCrcGpsSelect;
    }

    public void setLstCrcGpsSelect(List<caracteristica> lstCrcGpsSelect) {
        this.lstCrcGpsSelect = lstCrcGpsSelect;
    }

    public List<caracteristica> getLstCrcRadioSelect() {
        return lstCrcRadioSelect;
    }

    public void setLstCrcRadioSelect(List<caracteristica> lstCrcRadioSelect) {
        this.lstCrcRadioSelect = lstCrcRadioSelect;
    }

    public List<caracteristica> getLstCrcUsbSelect() {
        return lstCrcUsbSelect;
    }

    public void setLstCrcUsbSelect(List<caracteristica> lstCrcUsbSelect) {
        this.lstCrcUsbSelect = lstCrcUsbSelect;
    }

    public List<caracteristica> getLstCrcOtherSelect() {
        return lstCrcOtherSelect;
    }

    public void setLstCrcOtherSelect(List<caracteristica> lstCrcOtherSelect) {
        this.lstCrcOtherSelect = lstCrcOtherSelect;
    }

    public List<caracteristica> getLstCrcTalktimeSelect() {
        return lstCrcTalktimeSelect;
    }

    public void setLstCrcTalktimeSelect(List<caracteristica> lstCrcTalktimeSelect) {
        this.lstCrcTalktimeSelect = lstCrcTalktimeSelect;
    }

    public List<caracteristica> getLstCrcMusicplaySelect() {
        return lstCrcMusicplaySelect;
    }

    public void setLstCrcMusicplaySelect(List<caracteristica> lstCrcMusicplaySelect) {
        this.lstCrcMusicplaySelect = lstCrcMusicplaySelect;
    }

    public List<caracteristica> getLstCrcBatteryTypeSelect() {
        return lstCrcBatteryTypeSelect;
    }

    public void setLstCrcBatteryTypeSelect(List<caracteristica> lstCrcBatteryTypeSelect) {
        this.lstCrcBatteryTypeSelect = lstCrcBatteryTypeSelect;
    }

    //    METODOS
    public void cargarCrcASolucion(solucionBean sb){
        this.unificarListasCrc();   //  Unifico las listas
        sb.getSol().lstCrc = this.lstCaracteristicas;
    }

    private void unificarListasCrc(){
        for(caracteristica c : this.lstCrcTechnologySelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcDimensionsSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcWeightSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcSimSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcTypeSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcSizeSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcResolutionSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcMultiTouchSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcProtectionSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcOsSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcChipsetSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcCpuSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcGpuSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcCardslotSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcInternalSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcPrimarySelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcFeaturesSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcVideoSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcSecondarySelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcAlertsSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcLoudspeakerSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcJackSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcWlanSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcBlueSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcGpsSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c: this.lstCrcRadioSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcUsbSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcOtherSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcTalktimeSelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcMusicplaySelect){
            this.lstCaracteristicas.add(c);
        }
        for(caracteristica c : this.lstCrcBatteryTypeSelect){
            this.lstCaracteristicas.add(c);
        }
    }
}
