# TextChain

TODO: Write a project description

## Installation

Gradle

```
compile 'com.ripzery:textchain:1.0'
```

## Usage

        final ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Phuchit");
        words.add("Sirimongkolsathien");

        TextChain textChain = new TextChain(words, tvHello);
        textChain.setDuration(2000);
        textChain.setOnTextUpdateListener(new OnTextUpdateListener() {
            @Override
            public void onNext(int index) {
                Log.d("NextWord", "onNext: " + words.get(index));
            }

            @Override
            public void onFinish() {
                Log.d("Finish", "onFinish ");
            }
        });
        textChain.build().start();

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## History

TODO: Write history

## Credits

TODO: Write credits

## License

Copyright 2015 Phuchit

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.