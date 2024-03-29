package run_length_compression_test

import (
	"log"
	"os"
	"testing"

	progress "go-epi-judge/progress/lib"
	"go-epi-judge/test_utils/config"
)

var cfg *config.Config

func TestMain(m *testing.M) {
	var err error
	cfg, err = config.Parse()
	if err != nil {
		panic(err)
	}

	code := m.Run()

	if err = progress.PersistResult(code); err != nil {
		log.Print(err)
	}
	os.Exit(code)
}
