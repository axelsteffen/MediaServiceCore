# Changelog – Fork-spezifische Änderungen (MediaServiceCore)

Änderungen in diesem Submodul gegenüber dem Original.

---

## 2026-02-13

### youtubeapi
- **VideoInfo.java** (`youtubeapi/videoinfo/models/VideoInfo.java`): Unterstützung für YouTube-Videokategorien
- **PlayerResult.kt** / **PlayerResultExtensions.kt**: Kategorie-Erkennung aus Player-Ergebnissen
- **MediaItemFormatInfoImpl.kt**: Kategorie-Anreicherung für MediaItemFormatInfo
- **YouTubeMediaItemFormatInfo.java**: Kategorie-Feld für YouTube-spezifische Format-Infos

### mediaserviceinterfaces
- **MediaItemFormatInfo.java**: Neues Feld für Videokategorien

### Tests
- **VideoInfoCategoryTest.java** (neu): Test zum Parsen von YouTube-Videokategorien aus VideoInfo
