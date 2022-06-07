# Software Design

## Description

With Newsify users can search articles by its category. When he searches for a category the
headline and a link to the articles related to the category are displayed to the user.
Currently the information about the articles are gathered via the RSS api from SRF (Swiss Radio
and Television). If there is enough time left, we plan to offer a feature where the user can choose
the RSS feed or add a new one. Another optional feature would be, that the user is able to
categorize the articles manually.

## Use Case Specification

|                |                                                 |
| -------------- | ----------------------------------------------- |
| Nr.            | 1                                               |
| Title          | Poll news                                       |
| Actors         | System                                          |
| Pre-condition  | Connection to the internet                      |
| Main Scenario  | System polls all defined RSS-feeds via internet |
| Post-condition | New articles added or not                       |
| Exceptions     | No internet, Invalid URL, Host unreachable      |

|                |                                 |
| -------------- | ------------------------------- |
| Nr.            | 2                               |
| Title          | View feed                       |
| Actors         | User                            |
| Pre-condition  | Articles loaded                 |
| Main Scenario  | User reads the headlines        |
| Post-condition | User is informed or bored       |
| Exceptions     | No articles exist, invalid data |

|                |                                                           |
| -------------- | --------------------------------------------------------- |
| Nr.            | 3                                                         |
| Title          | Open article in web                                       |
| Actors         | User                                                      |
| Pre-condition  | Articles loaded                                           |
| Main Scenario  | User clicks on a linkt to an article                      |
| Post-condition | Webbrowser is open                                        |
| Exceptions     | No browser installed, Invalid URL, No internet connection |

|                |                                                                   |
| -------------- | ----------------------------------------------------------------- |
| Nr.            | 4                                                                 |
| Title          | Filter articles by category                                       |
| Actors         | User                                                              |
| Pre-condition  | Articles loaded and categorized                                   |
| Main Scenario  | User can select a category to only view articles of that category |
| Post-condition | Only articles of selected category shown                          |
| Exceptions     | Invalid category, No categories                                   |

### Optional Use Cases

These Use Cases will only be implemented, if there's enough time left.

|                |                                               |
| -------------- | --------------------------------------------- |
| Nr.            | 5                                             |
| Title          | Add new RSS feed                              |
| Actors         | User                                          |
| Pre-condition  | System is running                             |
| Main Scenario  | User can add a custom RSS feed to the library |
| Post-condition | RSS feed is added and will be polled          |
| Exceptions     | Invalid URL, No input                         |

|                |                                                                |
| -------------- | -------------------------------------------------------------- |
| Nr.            | 6                                                              |
| Title          | Categorize articles                                            |
| Actors         | User                                                           |
| Pre-condition  | Articles loaded                                                |
| Main Scenario  | User wants to manually change the category of a single article |
| Post-condition | Category of article changed                                    |
| Exceptions     | Invalid category                                               |
