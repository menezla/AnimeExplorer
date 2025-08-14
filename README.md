# Anime Explorer

A modern Android app that fetches and displays anime information using the Jikan API, built with Jetpack Compose and following MVVM architecture with Koin dependency injection.

## Features Implemented

### ✅ Core Requirements
- **Anime List Page**: Displays top anime with title, episodes, rating, and poster images
- **Anime Detail Page**: Shows comprehensive anime information including synopsis, genres, cast, and **video trailer player**
- **Jikan API Integration**: Uses official MyAnimeList API through Jikan wrapper
- **Modern UI**: Built with Jetpack Compose and Material 3 design
- **Video Player**: Supports YouTube embeds for trailers with fallback to poster images

### ✅ Bonus Features
- **Local Database with Room**: Offline data storage for anime list and details
- **Offline Mode & Syncing**: App works without internet, syncs when online
- **Error Handling**: Graceful error handling for network, database, and edge cases
- **Clean Architecture**: MVVM pattern with Repository pattern
- **Dependency Injection**: Koin for dependency management

### ✅ Technical Implementation
- **Networking**: Retrofit with OkHttp for API calls
- **Image Loading**: Coil for efficient image loading and caching
- **Database**: Room with KSP for local storage
- **Navigation**: Jetpack Navigation Compose
- **State Management**: StateFlow for reactive UI updates
- **Coroutines**: Async operations and background processing
- **Dependency Injection**: Koin for clean dependency management

## Architecture

```
app/
├── data/
│   ├── local/          # Room database entities and DAOs
│   │   ├── AnimeEntity.kt
│   │   ├── AnimeDetailsEntity.kt
│   │   ├── AnimeDao.kt
│   │   ├── AnimeDetailsDao.kt
│   │   └── AnimeDatabase.kt
│   ├── remote/         # API service and DTOs
│   │   ├── ApiService.kt
│   │   └── dto.kt
│   └── repository/     # Repository pattern implementation
│       └── AnimeRepository.kt
├── di/                 # Dependency injection modules
│   ├── NetworkModule.kt
│   ├── DatabaseModule.kt
│   ├── RepositoryModule.kt
│   └── ViewModelModule.kt
├── ui/
│   ├── actions/        # UI actions and events
│   │   ├── animeList/
│   │   └── animeDetails/
│   ├── screens/        # Compose UI screens
│   │   ├── animeList/
│   │   └── animeDetails/
│   ├── components/     # Reusable UI components
│   │   ├── TrailerPlayer.kt
│   │   ├── YouTubePlayer.kt
│   │   └── SharedComponents.kt
│   ├── theme/          # Material 3 theming
│   └── viewmodel/      # ViewModels with StateFlow
├── util/               # App constants and utilities
│   └── AppConstants.kt
└── MainActivity.kt     # Main activity with navigation setup
```

## API Endpoints Used

- `GET /v4/top/anime` - Fetch top anime list
- `GET /v4/anime/{id}` - Fetch anime details
- `GET /v4/anime/{id}/characters` - Fetch anime characters

## Libraries Used

- **Jetpack Compose** - Modern UI toolkit
- **Retrofit + OkHttp** - Network requests with logging interceptor
- **Coil** - Image loading and caching
- **Room + KSP** - Local database with compile-time code generation
- **Navigation Compose** - Screen navigation
- **ViewModel + StateFlow** - State management
- **Coroutines** - Asynchronous programming
- **Koin** - Dependency injection
- **android-youtube-player** - YouTube video playback
- **Material 3** - Modern design system

## Dependency Injection Setup

The app uses Koin for dependency injection with the following modules:

- **NetworkModule**: Provides Retrofit, OkHttp, and API service
- **DatabaseModule**: Provides Room database and DAOs
- **RepositoryModule**: Provides repository implementations
- **ViewModelModule**: Provides ViewModels

## Video Player Implementation

The app includes a sophisticated video player system:

- **YouTubePlayer**: Uses `android-youtube-player` library for YouTube video playback
- **TrailerPlayer**: Wrapper component that handles both YouTube videos and poster fallbacks
- **Error Handling**: Graceful fallback to poster images when videos are unavailable
- **Loading States**: Proper loading indicators and error messages

## Assumptions Made

1. **Image Fallback**: If profile images become unavailable due to legal changes, the app gracefully falls back to placeholder images
2. **Network Resilience**: App handles network failures and provides offline functionality
3. **Data Caching**: Anime data is cached locally for offline access
4. **Error Recovery**: Users can retry failed operations
5. **Responsive Design**: UI adapts to different screen sizes
6. **Video Fallback**: When trailers are unavailable, poster images are displayed with overlay text

## Known Limitations

1. **API Rate Limiting**: Jikan API has rate limits that may affect performance
2. **Trailer Support**: Only YouTube videos are supported; direct video URLs are not handled
3. **Character Images**: Character profile images are not displayed due to potential legal constraints
4. **Search Functionality**: No search feature implemented (focus on top anime list)
5. **Pagination**: Only first page of anime results is loaded
6. **Orientation**: App is locked to portrait mode for consistent video player experience

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

## Video Player Features

- **YouTube Integration**: Seamless YouTube video playback
- **Loading States**: Proper loading indicators during video initialization
- **Error Handling**: Graceful error display with retry options
- **Fallback System**: Poster images displayed when videos are unavailable
- **Lifecycle Management**: Proper cleanup of video resources

## Development Notes

- **Koin Integration**: Clean dependency injection setup with proper module organization
- **State Management**: Uses StateFlow for reactive UI updates
- **Error Handling**: Comprehensive error handling at all layers
- **Code Organization**: Well-structured with clear separation of concerns
- **Documentation**: Extensive code documentation with author attribution
