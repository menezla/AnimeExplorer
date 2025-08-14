# Anime Explorer

A modern Android app that fetches and displays anime information using the Jikan API, built with Jetpack Compose and following MVVM architecture.

## Features Implemented

### ✅ Core Requirements
- **Anime List Page**: Displays top anime with title, episodes, rating, and poster images
- **Anime Detail Page**: Shows comprehensive anime information including synopsis, genres, cast, and **video trailer player**
- **Jikan API Integration**: Uses official MyAnimeList API through Jikan wrapper
- **Modern UI**: Built with Jetpack Compose and Material 3 design
- **Video Player**: Supports both direct video URLs and YouTube embeds for trailers

### ✅ Bonus Features
- **Local Database with Room**: Offline data storage for anime list and details
- **Offline Mode & Syncing**: App works without internet, syncs when online
- **Error Handling**: Graceful error handling for network, database, and edge cases
- **Clean Architecture**: MVVM pattern with Repository pattern

### ✅ Technical Implementation
- **Networking**: Retrofit with OkHttp for API calls
- **Image Loading**: Coil for efficient image loading and caching
- **Database**: Room with KSP for local storage
- **Navigation**: Jetpack Navigation Compose
- **State Management**: StateFlow for reactive UI updates
- **Coroutines**: Async operations and background processing

## Architecture

```
app/
├── data/
│   ├── local/          # Room database entities and DAOs
│   ├── remote/         # API service and DTOs
│   └── repository/     # Repository pattern implementation
├── di/                 # Dependency injection modules
├── ui/
│   ├── screens/        # Compose UI screens
│   ├── theme/          # Material 3 theming
│   └── viewmodel/      # ViewModels with StateFlow
└── navigation/         # Navigation setup
```

## API Endpoints Used

- `GET /v4/top/anime` - Fetch top anime list
- `GET /v4/anime/{id}` - Fetch anime details
- `GET /v4/anime/{id}/characters` - Fetch anime characters

## Libraries Used

- **Jetpack Compose** - Modern UI toolkit
- **Retrofit + OkHttp** - Network requests
- **Coil** - Image loading
- **Room + KSP** - Local database
- **Navigation Compose** - Screen navigation
- **ViewModel + StateFlow** - State management
- **Coroutines** - Asynchronous programming
- **ExoPlayer (Media3)** - Video playback for trailers
- **WebView** - YouTube embed support

## Assumptions Made

1. **Image Fallback**: If profile images become unavailable due to legal changes, the app gracefully falls back to placeholder images
2. **Network Resilience**: App handles network failures and provides offline functionality
3. **Data Caching**: Anime data is cached locally for offline access
4. **Error Recovery**: Users can retry failed operations
5. **Responsive Design**: UI adapts to different screen sizes

## Known Limitations

1. **API Rate Limiting**: Jikan API has rate limits that may affect performance
2. **Trailer Support**: Video player supports both direct URLs and YouTube embeds, falls back to poster if unavailable
3. **Character Images**: Character profile images are not displayed due to potential legal constraints
4. **Search Functionality**: No search feature implemented (focus on top anime list)
5. **Pagination**: Only first page of anime results is loaded

## How to Run

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run on device or emulator

## Network Permissions

The app requires:
- `INTERNET` - For API calls
- `ACCESS_NETWORK_STATE` - For network status monitoring

## Offline Support

The app provides full offline functionality:
- Cached anime list available without internet
- Detailed anime information stored locally
- Automatic sync when connection is restored
- Graceful error handling for network failures
